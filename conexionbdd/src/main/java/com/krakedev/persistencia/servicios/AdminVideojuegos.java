package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Videojuegos;
import com.krakedev.persistencia.utils.Conexionbdd;

public class AdminVideojuegos {
	private static final Logger LOGGER=LogManager.getLogger(AdminVideojuegos.class);
	public static void insertar (Videojuegos videojuegos) throws Exception {
		Connection con=null;
		PreparedStatement ps;
		LOGGER.trace("VIDEOJUEGO A INSERTAR "+videojuegos);
		try {
			//abrir la conexion
			con=Conexionbdd.conectar();
			ps=con.prepareStatement("insert into videojuegos(codigo,nombre,descripcion,valoracion, plataformas_codigo_videojuego,fecha_publicacion)"
					+ "values(?,?,?,?,?,?)");
			ps.setInt(1, videojuegos.getCodigo());
			ps.setString(2, videojuegos.getNombre());
			ps.setString(3, videojuegos.getDescripcion());
			ps.setInt(4, videojuegos.getValoracion());
			ps.setInt(5, videojuegos.getCodigoPlataforma().getCodigoVideojuego());
			ps.setDate(6, new java.sql.Date(videojuegos.getFechaPublicacion().getTime()));
			ps.executeUpdate();
		}catch (Exception e){
			//loggear el error
			LOGGER.error("ERROR AL INSERTAR",e);
			throw new Exception("ERROR AL INSERTAR");
		}finally {
			//cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("ERROR CON LA BASE DE DATOS",e);
				throw new Exception("ERROR CON LA BASE DE DATOS");
			}
		}
	}

	public static void actualizar(Videojuegos videojuegos) throws Exception {
	    Connection con = null;
	    PreparedStatement ps;
	    LOGGER.trace("VIDEOJUEGO A ACTUALIZAR " + videojuegos);
	    try {
	        con = Conexionbdd.conectar();
	        ps = con.prepareStatement("UPDATE videojuegos SET nombre = ?, descripcion = ?, valoracion = ?, plataformas_codigo_videojuego = ?, fecha_publicacion = ? WHERE codigo = ?");
	        ps.setString(1, videojuegos.getNombre());
	        ps.setString(2, videojuegos.getDescripcion());
	        ps.setInt(3, videojuegos.getValoracion());
	        ps.setInt(4, videojuegos.getCodigoPlataforma().getCodigoVideojuego());
	        ps.setDate(5, new java.sql.Date(videojuegos.getFechaPublicacion().getTime()));
	        ps.setInt(6, videojuegos.getCodigo());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        LOGGER.error("ERROR AL ACTUALIZAR", e);
	        throw new Exception("ERROR AL ACTUALIZAR");
	    } finally {
	        try {
	            con.close();
	        } catch (SQLException e) {
	            LOGGER.error("ERROR CON LA BASE DE DATOS", e);
	            throw new Exception("ERROR CON LA BASE DE DATOS");
	        }
	    }
	}	

	public static void eliminar(String codigo) throws Exception {
	    Connection con = null;
	    PreparedStatement ps;
	    LOGGER.trace("ELIMINAR VIDEOJUEGO CON CODIGO " + codigo);
	    try {
	        con = Conexionbdd.conectar();
	        ps = con.prepareStatement("DELETE FROM videojuegos WHERE codigo = ?");
	        ps.setString(1, codigo);
	        ps.executeUpdate();
	    } catch (Exception e) {
	        LOGGER.error("ERROR AL ELIMINAR", e);
	        throw new Exception("ERROR AL ELIMINAR");
	    } finally {
	        try {
	            con.close();
	        } catch (SQLException e) {
	            LOGGER.error("ERROR CON LA BASE DE DATOS", e);
	            throw new Exception("ERROR CON LA BASE DE DATOS");
	        }
	    }
	}


}


