package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.exceptions.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class TipoDocumentoBDD {
	public ArrayList<TipoDocumento> recuperarTiposDoc() throws KrakeDevException, SQLException{
		ArrayList<TipoDocumento> tipoDocumentos= new ArrayList<TipoDocumento>();
		Connection con = null; 
		PreparedStatement ps=null;
		ResultSet rs= null;
		TipoDocumento tipoDoc=null;
		try {
			con=ConexionBDD.obtenerConexion();
			ps=con.prepareStatement("select codigo, descripcion from tipo_documento");
			rs=ps.executeQuery();
			
			while (rs.next()) {
				String codigo = rs.getString("codigo");
				String descripcion = rs.getString("descripcion");
				tipoDoc = new TipoDocumento(codigo,descripcion);
				tipoDocumentos.add(tipoDoc);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL CONSULTAR. DETALLE: " +e.getMessage());
		}
		return tipoDocumentos;
	}
	
}