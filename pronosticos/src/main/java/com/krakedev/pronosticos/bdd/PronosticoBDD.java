package com.krakedev.pronosticos.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.pronosticos.entidades.Pronostico;
import com.krakedev.pronosticos.exceptions.KrakeDevException;
import com.krakedev.pronosticos.utils.ConexionBDD;

public class PronosticoBDD {
	 public ArrayList<Pronostico> consultarPronosticosPorUsuario(int usuarioId) throws KrakeDevException {
	        ArrayList<Pronostico> pronosticos = new ArrayList<>();
	        Connection con = null;
	        ResultSet rs = null;
	        try {
	            con = ConexionBDD.obtenerConexion();
	            PreparedStatement ps = con.prepareStatement(
	                "SELECT p.id, p.usuario_id, p.partido_id, p.goles_local, p.goles_visitante " +
	                "FROM pronosticos p WHERE p.usuario_id = ?;"
	            );
	            ps.setInt(1, usuarioId);
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                int partidoId = rs.getInt("partido_id");
	                int golesLocal = rs.getInt("goles_local");
	                int golesVisitante = rs.getInt("goles_visitante");

	                Pronostico pronostico = new Pronostico(id, usuarioId, partidoId, golesLocal, golesVisitante);
	                pronosticos.add(pronostico);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new KrakeDevException("ERROR AL CONSULTAR PRONÓSTICOS: " + e.getMessage());
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return pronosticos;
	    }

	 public void insertarPronostico(Pronostico pronostico) throws KrakeDevException {
	        Connection con = null;
	        try {
	            con = ConexionBDD.obtenerConexion();
	            PreparedStatement ps = con.prepareStatement(
	                "INSERT INTO pronosticos (usuario_id, partido_id, goles_local, goles_visitante) VALUES (?, ?, ?, ?);"
	            );
	            ps.setInt(1, pronostico.getUsuarioId());
	            ps.setInt(2, pronostico.getPartidoId());
	            ps.setInt(3, pronostico.getGolesLocal());
	            ps.setInt(4, pronostico.getGolesVisitante());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new KrakeDevException("ERROR AL INSERTAR PRONÓSTICO: " + e.getMessage());
	        } finally {
	            try {
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
