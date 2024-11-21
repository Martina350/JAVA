package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.exceptions.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class PedidosBDD {
	public void insertarPedido(Pedido pedido) throws KrakeDevException {
		Connection con = null;
		Date fechaActual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
		ResultSet rsClave = null;
		int codigoCabecera = 0;

		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement(
					"insert into cabecera_pedido (proveedor, fecha, estado) " + "values (?,?,?); ",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pedido.getProveedor().getIdentificacion());
			ps.setDate(2, fechaSQL);
			ps.setString(3, "s");

			ps.executeUpdate();

			rsClave = ps.getGeneratedKeys();

			if (rsClave.next()) {
				codigoCabecera = rsClave.getInt(1);
			}

			ArrayList<DetallePedido> detallesPedido = pedido.getDetalles();
			DetallePedido det;
			for (int i = 0; i < detallesPedido.size(); i++) {
				det = detallesPedido.get(i);
				PreparedStatement psDet = con.prepareStatement(
						"insert into detalle_pedido (cabecera_de_pedido, producto, cantidad_solicitada, subtotal, cantidad_recibida) "
								+ "values (?, ?, ?, ?, ?); ");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigoProducto());
				psDet.setInt(3, det.getCantidadSolicitada());
				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidadSolicitada());
				BigDecimal subTotal = pv.multiply(cantidad);
				psDet.setBigDecimal(4, subTotal);
				psDet.setInt(5, 0);

				psDet.executeUpdate();

			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL INSERTAR PEDIDO. DETALLE: " + e.getMessage());
		}
	}

	public void actualizarEstadoPedido(Pedido pedido) throws KrakeDevException {
		Connection con = null;
		Date fechaActual = new Date();
		Timestamp fechaHoraActual = new Timestamp(fechaActual.getTime());
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("update cabecera_pedido " + "set estado='r' where codigo =? ");
			ps.setInt(1, pedido.getCodigo());
			ps.executeUpdate();

			ArrayList<DetallePedido> detallesPedido = pedido.getDetalles();
			DetallePedido det;
			for (int i = 0; i < detallesPedido.size(); i++) {
				det = detallesPedido.get(i);
				PreparedStatement psDet = con.prepareStatement(
						"update detalle_pedido " + "set cantidad_recibida=?, subtotal=? " + "where codigo=?");
				psDet.setInt(1, det.getCantidadRecibida());
				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidadSolicitada());
				BigDecimal subTotal = pv.multiply(cantidad);
				psDet.setBigDecimal(2, subTotal);
				psDet.setInt(3, det.getCodigo());

				psDet.executeUpdate();

				PreparedStatement psHis = con
						.prepareStatement("insert into historial_stock (fecha, referencia, producto, cantidad) "
								+ "values (?, ?, ?, ?); ");
				psHis.setTimestamp(1, fechaHoraActual);
				psHis.setString(2, "PEDIDO: " + det.getCodigo());
				psHis.setInt(3, det.getProducto().getCodigoProducto());
				psHis.setInt(4, det.getCantidadRecibida());

				psHis.executeUpdate();

			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL ACTUALIZAR PEDIDO. DETALLE: " + e.getMessage());
		}

	}

	public ArrayList<DetallePedido> buscarPedidoPorProveedor(String proveedor) throws KrakeDevException {
	    ArrayList<DetallePedido> pedidos = new ArrayList<DetallePedido>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    DetallePedido detallePedido = null;

	    try {
	        con = ConexionBDD.obtenerConexion();
	        ps = con.prepareStatement(
	            "SELECT dp.codigo, " +
	            "       dp.cabecera_de_pedido, " +
	            "       cp.proveedor, " +
	            "       dp.producto, " +
	            "       dp.cantidad_solicitada, " +
	            "       CAST(dp.subtotal AS DECIMAL(10,3)) AS subtotal, " +
	            "       dp.cantidad_recibida " +
	            "FROM detalle_pedido dp " +
	            "JOIN cabecera_pedido cp ON dp.cabecera_de_pedido = cp.codigo " +
	            "JOIN proveedor prov ON cp.proveedor = prov.identificacion " +
	            "WHERE prov.identificacion LIKE ?"
	        );
	        ps.setString(1, proveedor);
	        
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            int codigo = rs.getInt("codigo");
	            int cabecera = rs.getInt("cabecera_de_pedido");
	            String proveedorDb = rs.getString("proveedor");
	            int codigoProducto = rs.getInt("producto");
	            int cantidadSolicitada = rs.getInt("cantidad_solicitada");
	            BigDecimal subtotal = rs.getBigDecimal("subtotal");
	            int cantidadRecibida = rs.getInt("cantidad_recibida");

	            Producto producto = new Producto(codigoProducto);
	            Proveedor proveedorObj = new Proveedor(proveedorDb);
	            Pedido pedido = new Pedido(cabecera, proveedorObj);

	            detallePedido = new DetallePedido(codigo, pedido, producto, cantidadSolicitada, subtotal, cantidadRecibida);
	            pedidos.add(detallePedido);
	        }
	    } catch (KrakeDevException e) {
	        e.printStackTrace();
	        throw e;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new KrakeDevException("ERROR AL RECUPERAR PEDIDOS. DETALLE: " + e.getMessage());
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return pedidos;
	}
}
