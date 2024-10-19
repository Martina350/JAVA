package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.persistencia.entidades.Prestamo;
import com.krakedev.persistencia.utils.Conexionbdd;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdminPrestamo {
	   private static final Logger LOGGER = LogManager.getLogger(AdminPrestamo.class);

	    public static void insertar(Prestamo prestamo) throws Exception {
	        Connection con = null;
	        PreparedStatement ps;
	        try {
	            con = Conexionbdd.conectar();
	            ps = con.prepareStatement("insert into prestamo (cedula, monto, fecha_prestamo, hora_prestamo, garante)" 
	            		+ "values (?, ?, ?, ?, ?)");
	            ps.setString(1, prestamo.getCedula());
	            ps.setBigDecimal(2, prestamo.getMonto());
	            ps.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
	            ps.setTime(4, new java.sql.Time(prestamo.getHoraPrestamo().getTime()));
	            ps.setString(5, prestamo.getGarante());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            LOGGER.error("ERROR AL INSERTAR", e);
	            throw new Exception("ERROR AL INSERTAR PRESTAMO");
	        } finally {
	            if (con != null) {
	                con.close();
	            }
	        }
	    }

	    public static void actualizar(Prestamo prestamo) throws Exception {
	        Connection con = null;
	        PreparedStatement ps;
	        try {
	            con = Conexionbdd.conectar();
	            ps = con.prepareStatement("UPDATE prestamo SET monto = ?, fecha_prestamo = ?, hora_prestamo = ?, garante = ? WHERE cedula = ?");
	            ps.setBigDecimal(1, prestamo.getMonto());
	            ps.setDate(2, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
	            ps.setTime(3, new java.sql.Time(prestamo.getHoraPrestamo().getTime()));
	            ps.setString(4, prestamo.getGarante());
	            ps.setString(5, prestamo.getCedula());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            LOGGER.error("ERROR AL ACTUALIZAR", e);
	            throw new Exception("ERROR AL ACTUALIZAR PRESTAMO");
	        } finally {
	            if (con != null) {
	                con.close();
	            }
	        }
	    }

	    public static void eliminar(String cedula) throws Exception {
	        Connection con = null;
	        PreparedStatement ps;
	        try {
	            con = Conexionbdd.conectar();
	            ps = con.prepareStatement("DELETE FROM prestamo WHERE cedula = ?");
	            ps.setString(1, cedula);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            LOGGER.error("ERROR AL ELIMINAR", e);
	            throw new Exception("ERROR AL ELIMINAR PRESTAMO");
	        } finally {
	            if (con != null) {
	                con.close();
	            }
	        }
	    }
}
