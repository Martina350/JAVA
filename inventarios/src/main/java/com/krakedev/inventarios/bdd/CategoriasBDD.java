package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.exceptions.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class CategoriasBDD {
	public void insertarCategoria(Categoria categoria) throws KrakeDevException {
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("insert into categorias (codigo_cat, nombre, categoria_padre) " 
			+ "values (?, ?, ?); ");
			ps.setInt(1, categoria.getCodigoCat());
			ps.setString(2, categoria.getNombre());
			if (categoria.getCategoriaPadre() != null) {
				ps.setInt(3, categoria.getCategoriaPadre().getCodigoCat());
			} else {
				ps.setNull(3, java.sql.Types.INTEGER);
			}

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL INSERTAR CATEGORIA. DETALLE: " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void actualizarCategoria(Categoria categoria) throws KrakeDevException {
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("UPDATE categorias SET nombre = ?, categoria_padre = ? " 
			+ "WHERE codigo_cat = ? ");
			ps.setString(1, categoria.getNombre());
			ps.setInt(2, categoria.getCategoriaPadre().getCodigoCat());
			ps.setInt(3, categoria.getCodigoCat());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL ACTUALIZAR CATEGORIA. DETALLE: " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<Categoria> obtenerCategorias() throws KrakeDevException, SQLException {
	    ArrayList<Categoria> categorias = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        con = ConexionBDD.obtenerConexion();
	        ps = con.prepareStatement("SELECT codigo_cat, nombre FROM categorias");
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            Categoria categoria = new Categoria();
	            categoria.setCodigoCat(rs.getInt("codigo_cat"));
	            categoria.setNombre(rs.getString("nombre"));
	            categorias.add(categoria);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new KrakeDevException("ERROR AL RECUPERAR CATEGORIAS. DETALLE: " + e.getMessage());
	    }
	    return categorias;
	}

}
