package com.krakedev.persistencia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.servicios.AdminVideojuegos;

public class Conexionbdd {
	private final static String DRIVER="org.postgresql.Driver";
	private final static String URL="jdbc:postgresql://localhost:5432/postgres";
	private final static String USUARIO="postgres";
	private final static String PASSWORD="Brownie05";
	private static final Logger LOGGER=LogManager.getLogger(Conexionbdd.class);
	public static Connection conectar() throws Exception{
		Connection connection=null;
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USUARIO,PASSWORD);
			LOGGER.debug("CONEXION EXITOSA");
		} catch (ClassNotFoundException e) {
			LOGGER.error("ERROR EN LA INFRAESTRUCTURA",e);
			throw new Exception("ERROR EN LA INFRAESTRUCTURA");
		} catch (SQLException e) {
			LOGGER.error("ERROR AL CONECTARSE, REVISE USUARIO Y CLAVE",e);
			throw new Exception("ERROR AL CONECTARSE, REVISE USUARIO Y CLAVE");
		}
		return connection;
	}
}
