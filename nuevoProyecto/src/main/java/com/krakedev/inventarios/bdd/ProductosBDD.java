package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.UnidadDeMedida;
import com.krakedev.inventarios.exceptions.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProductosBDD {
	public ArrayList<Producto> buscar(String subcadena) throws KrakeDevException, SQLException {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto producto = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select prod.codigo_producto, prod.nombre, udm.codigo_udm, "
					+ "udm.descripcion as descripcion_udm, cast(prod.precio_venta as decimal(6,2)), "
					+ "prod.tiene_iva, cast(prod.coste as decimal(5,4)), "
					+ "prod.categoria, cat.nombre as nombre_categoria, prod.stock "
					+ "from producto prod, unidades_medida udm, categorias cat "
					+ "where prod.udm = udm.codigo_udm "
					+ "and prod.categoria = cat.codigo_cat "
					+ "and upper (prod.nombre) like ?");
			ps.setString(1, "%" + subcadena.toUpperCase() + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				int codigoProducto= rs.getInt("codigo_producto");
				String nombreProducto= rs.getString("nombre");
				String nombreUDM= rs.getString("codigo_udm");
				String descripcionUDM= rs.getString("descripcion_udm");
				BigDecimal precioVenta= rs.getBigDecimal("precio_venta");
				boolean tieneIva= rs.getBoolean("tiene_iva");
				BigDecimal coste= rs.getBigDecimal("coste");
				int codigoCategoria= rs.getInt("categoria");
				String nombreCategoria= rs.getString("nombre_categoria");
				int stock= rs.getInt("stock");
				
				UnidadDeMedida udm= new UnidadDeMedida();
				udm.setCodigoUdm(nombreUDM);
				udm.setDescripcion(descripcionUDM);
				
				Categoria categoria=new Categoria();
				categoria.setCodigoCat(codigoCategoria);
				categoria.setNombre(nombreCategoria);
				
				producto= new Producto();
				producto.setCodigoProducto(codigoProducto);
				producto.setNombre(nombreProducto);
				producto.setUdm(udm);
				producto.setPrecioVenta(precioVenta);
				producto.setTieneIva(tieneIva);
				producto.setCoste(coste);
				producto.setCategoria(categoria);
				producto.setStock(stock);
				
				productos.add(producto);
			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL CONSULTAR. DETALLE: " + e.getMessage());
		}
		return productos;
	}
	
	
	public void insertarProducto(Producto producto) throws KrakeDevException {
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("insert into producto(codigo_producto, nombre, udm, precio_venta, tiene_iva, coste, categoria, stock) "
					+ "values (?,?,?,?,?,?,?,?);");
			ps.setInt(1, producto.getCodigoProducto());
			ps.setString(2, producto.getNombre());
			ps.setString(3, producto.getUdm().getCodigoUdm());
			ps.setBigDecimal(4, producto.getPrecioVenta());
	        ps.setBoolean(5, producto.isTieneIva());
	        ps.setBigDecimal(6, producto.getCoste());
	        ps.setInt(7, producto.getCategoria().getCodigoCat());
	        ps.setInt(8, producto.getStock());
			
			ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL INSERTAR PRODUCTO. DETALLE: " + e.getMessage());
		}
	}
}