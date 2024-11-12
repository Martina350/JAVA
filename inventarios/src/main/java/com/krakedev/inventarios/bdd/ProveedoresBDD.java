package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.exceptions.*;
import com.krakedev.inventarios.utils.ConexionBDD;
import com.krakedev.inventarios.entidades.Proveedor;

public class ProveedoresBDD {
	public ArrayList<Proveedor> buscar(String subcadena) throws KrakeDevException, SQLException{
		ArrayList<Proveedor> proveedores= new ArrayList<Proveedor>();
		Connection con = null; 
		PreparedStatement ps=null;
		ResultSet rs= null;
		Proveedor proveedor=null;
		try {
			con=ConexionBDD.obtenerConexion();
			ps=con.prepareStatement("select identificacion, tipo_documento, nombre, telefono, correo, direccion "
					+ "from proveedor "
					+ "where upper(nombre) like ?");
			ps.setString(1,"%"+subcadena.toUpperCase()+"%");
			rs=ps.executeQuery();
			
			while (rs.next()) {
				String identificacion = rs.getString("identificacion");
				String tipoDocumento = rs.getString("tipo_documento");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
				proveedor = new Proveedor(identificacion, tipoDocumento, nombre, telefono, correo, direccion);
				proveedores.add(proveedor);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL CONSULTAR. DETALLE: " +e.getMessage());
		}
		return proveedores;
	}
	
}
