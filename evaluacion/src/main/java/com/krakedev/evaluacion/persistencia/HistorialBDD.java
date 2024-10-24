package com.krakedev.evaluacion.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class HistorialBDD {
	public void insertar(Categoria categoria) throws KrakeException {
	    Connection con = null; 
	    try {
	        con = ConexionBDD.obtenerConexion();
	        PreparedStatement ps = con.prepareStatement("INSERT INTO categorias(nombre, id) VALUES (?, ?)");
	        ps.setString(1, categoria.getNombre());
	        ps.setString(2, categoria.getId());
	        ps.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new KrakeException("ERROR AL INSERTAR CATEGORIA. DETALLE: " + e.getMessage());
	        
	    } catch (KrakeException e) {
	        throw e;
	        
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
	
	public void actualizar(Categoria categoria) throws KrakeException {
	    Connection con = null; 
	    try {
	        con = ConexionBDD.obtenerConexion();
	        PreparedStatement ps = con.prepareStatement("UPDATE categorias SET nombre = ? WHERE id = ?");
	        ps.setString(1, categoria.getNombre());
	        ps.setString(2, categoria.getId());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new KrakeException("ERROR AL ACTUALIZAR CATEGORIA. DETALLE: " + e.getMessage());
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

	public Categoria buscarPorId(String idBusqueda) throws KrakeException, SQLException {
	    Connection con = null; 
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Categoria categoria = null;
	    
	    try {
	        con = ConexionBDD.obtenerConexion();
	        ps = con.prepareStatement("select id, nombre from categorias where id = ?");
	        ps.setString(1, idBusqueda);
	        rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            System.out.println("CATEGORIA ENCONTRADA");
	            String id = rs.getString("id");
	            String nombre = rs.getString("nombre");
	            categoria = new Categoria(id, nombre);
	        } else {
	            System.out.println("CATEGORIA NO ENCONTRADA");
	        }
	        
	    } catch (KrakeException e) {
	        e.printStackTrace();
	        throw e;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new KrakeException("ERROR AL CONSULTAR. DETALLE: " + e.getMessage());
	    }
	    
	    return categoria;
	}

	public ArrayList<Categoria> recuperarTodos() throws KrakeException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    ArrayList<Categoria> categorias = new ArrayList<>();
	    try {
	        con = ConexionBDD.obtenerConexion();
	        if (con != null) {
	            String query = "SELECT * FROM categorias";
	            ps = con.prepareStatement(query);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                Categoria categoria = new Categoria();
	                categoria.setId(rs.getString("id"));
	                categoria.setNombre(rs.getString("nombre"));;
	                categorias.add(categoria);
	            }
	        }
	    } catch (KrakeException e) {
	         e.printStackTrace();
	         throw e;
	    }catch (SQLException e) {
	         e.printStackTrace();
	         throw new KrakeException("ERROR AL CONSULTAR. DETALLE: " + e.getMessage());
	    }
	    
	    return categorias;
	}

}
