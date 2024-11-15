package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.exceptions.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class PedidosBDD {
	public void insertarPedido(Pedido pedido) throws KrakeDevException {
		Connection con = null;	
		Date fechaActual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
		ResultSet rsClave = null;
		int codigoCabecera=0;
		
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("insert into cabecera_pedido (proveedor, fecha, estado) "
					+ "values (?,?,?); ", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pedido.getProveedor().getIdentificacion());
			ps.setDate(2, fechaSQL);
			ps.setString(3, "s");
			
			ps.executeUpdate();
			
			rsClave = ps.getGeneratedKeys();
			
			if(rsClave.next()) {
				codigoCabecera=rsClave.getInt(1);
			}
			
			ArrayList<DetallePedido> detallesPedido=pedido.getDetalles();
			DetallePedido det;
			for(int i=0; i<detallesPedido.size(); i++) {
				det = detallesPedido.get(i);
				PreparedStatement psDet = con.prepareStatement("insert into detalle_pedido (cabecera_de_pedido, producto, cantidad_solicitada, subtotal, cantidad_recibida) "
						+ "values (?, ?, ?, ?, ?); ");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigoProducto());
				psDet.setInt(3, det.getCantidadSolicitada());
				BigDecimal pv=det.getProducto().getPrecioVenta();
				BigDecimal cantidad= new BigDecimal(det.getCantidadSolicitada());
				BigDecimal subTotal=pv.multiply(cantidad);
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
	
	public void actualizarEstadoPedido (Pedido pedido) throws KrakeDevException {
		Connection con = null;

		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("update cabecera_pedido "
					+ "set estado='r' where codigo =? ");
			ps.setInt(1, pedido.getCodigo());
			ps.executeUpdate();
			

			
			ArrayList<DetallePedido> detallesPedido=pedido.getDetalles();
			DetallePedido det;
			for(int i=0; i<detallesPedido.size(); i++) {
				det = detallesPedido.get(i);
				PreparedStatement psDet = con.prepareStatement("update detalle_pedido "
						+ "set cantidad_recibida=?, subtotal=? "
						+ "where codigo=?");				
			psDet.setInt(1, det.getCantidadRecibida()); 
			BigDecimal pv=det.getProducto().getPrecioVenta();
			BigDecimal cantidad= new BigDecimal(det.getCantidadSolicitada());
			BigDecimal subTotal=pv.multiply(cantidad);
	        psDet.setBigDecimal(2, subTotal);          
	        psDet.setInt(3, det.getCodigo());
	        
	        ps.executeUpdate();
				
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL ACTUALIZAR PEDIDO. DETALLE: " + e.getMessage());
		}
		
	}

}

