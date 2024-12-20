package com.krakedev.pronosticos.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.pronosticos.entidades.Equipo;
import com.krakedev.pronosticos.exceptions.KrakeDevException;
import com.krakedev.pronosticos.utils.ConexionBDD;

public class EquipoBDD {
	public void insertarEquipo(Equipo equipo) throws KrakeDevException {
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO equipos (codigo, codigo_num, nombre) VALUES (?, ?, ?);");
			ps.setString(1, equipo.getCodigo());
			ps.setInt(2, equipo.getCodigoNum());
			ps.setString(3, equipo.getNombre());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("ERROR AL INSERTAR EQUIPO: " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}