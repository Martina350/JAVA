package com.krakedev.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.entidades.Cliente;
import com.krakedev.execpciones.KrakeDevException;
import com.krakedev.utils.ConexionBdd;

public class ClientesBdd {
	public void insertar(Cliente cliente) throws KrakeDevException {
		Connection con = null; 
		try {
			con=ConexionBdd.obtenerConexion();
			PreparedStatement ps = 
			con.prepareStatement("insert into clientes(cedula,nombre,numeroHijos) "
					+ "values (?,?,?)");
			ps.setString(1, cliente.getCedula());
			ps.setString(2, cliente.getNombre());
			ps.setInt(3, cliente.getNumeroHijos());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException ("ERROR AL INSERTAR CLIENTE. DETALLE: "+e.getMessage());
		} catch (KrakeDevException e) {
			throw e;
		}finally {
			if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			}
		}
	}
	
	public void actualizar(Cliente cliente) throws KrakeDevException {
        Connection con = null; 
        try {
            con = ConexionBdd.obtenerConexion();
            PreparedStatement ps = con.prepareStatement("update clientes set nombre = ?, numeroHijos = ? where cedula = ?");
            ps.setString(1, cliente.getNombre());
            ps.setInt(2, cliente.getNumeroHijos());
            ps.setString(3, cliente.getCedula());

            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrakeDevException("ERROR AL ACTUALIZAR CLIENTE . DETALLE: " +e.getMessage());
        }finally {
			if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			}
		}
    }

	public ArrayList<Cliente> recuperarTodos() throws KrakeDevException, SQLException{
		ArrayList<Cliente> clientes= new ArrayList<Cliente>();
		Connection con = null; 
		PreparedStatement ps=null;
		ResultSet rs= null;
		Cliente cliente=null;
		try {
			con=ConexionBdd.obtenerConexion();
			ps=con.prepareStatement("select cedula,nombre, numeroHijos from clientes");
			rs=ps.executeQuery();
			
			while (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int numeroHijos = rs.getInt("numeroHijos");
				cliente = new Cliente(cedula, nombre, numeroHijos);
				clientes.add(cliente);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL CONSULTAR. DETALLE: " +e.getMessage());
		}
		return clientes;
	}
	
	public Cliente buscarPK(String cedulaBusqueda) throws KrakeDevException, SQLException{
		Connection con = null; 
		PreparedStatement ps=null;
		ResultSet rs= null;
		Cliente cliente=null;
		try {
			con=ConexionBdd.obtenerConexion();
			ps=con.prepareStatement("select cedula,nombre, numeroHijos from clientes where cedula = ?");
			ps.setString(1, cedulaBusqueda);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("EXISTE EL CLIENTE");
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int numeroHijos = rs.getInt("numeroHijos");
				cliente = new Cliente(cedula, nombre, numeroHijos);
			}else {
				System.out.println("NO EXITE EL CLIENTE");
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL CONSULTAR. DETALLE: " +e.getMessage());
		}
		return cliente;
	}

	public ArrayList<Cliente> buscarPorNumeroHijos(int numHijos) throws KrakeDevException, SQLException {
	    ArrayList<Cliente> clientes = new ArrayList<>();
	    Connection con = null; 
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Cliente cliente = null;
	    try {
	        con = ConexionBdd.obtenerConexion();
	        ps = con.prepareStatement("select cedula, nombre, numeroHijos from clientes where numeroHijos >= ?");
	        ps.setInt(1, numHijos);
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            String cedula = rs.getString("cedula");
	            String nombre = rs.getString("nombre");
	            int numeroHijos = rs.getInt("numeroHijos");
	            cliente = new Cliente(cedula, nombre, numeroHijos);
	            clientes.add(cliente);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new KrakeDevException("ERROR AL CONSULTAR CLIENTES POR NUMERO DE HIJOS. DETALLE: " + e.getMessage());
	    } finally {
	        if (con != null) {
	            con.close();
	        }
	    }
	    return clientes;
	}
}
