package com.krakedev.conexionbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexion {

	public static void main(String[] args) {
		PreparedStatement ps=null;
		Connection connection=null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Brownie05");
			System.out.println("CONEXION EXITOSA");
			ps=connection.prepareStatement("insert into videojuegos(codigo,nombre,descripcion,valoracion, plataformas_codigo_videojuego,fecha_publicacion)"
					+ "values(?,?,?,?,?,?)");
			ps.setInt(1, 12);
			ps.setString(2, "minecraft");
			ps.setString(3, "videojuego de construcción");
			ps.setInt(4, 10);
			ps.setInt(5, 5);
			
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechaStr="2024/11/06 10:05:04";
			try {
				Date fecha=sdf.parse(fechaStr);
				System.out.println(fecha);
				long fechaMilis=fecha.getTime();
				System.out.println(fechaMilis);
				//CREA UN JAVA.SQL.DATE PARTIENDO DE UN JAVA.UTIL.DATE
				java.sql.Date fechaSQL= new java.sql.Date(fechaMilis);
				System.out.println(fechaSQL);
				
				Time timeSQL=new Time(fechaMilis);
				System.out.println(timeSQL);
				
				ps.setDate(6, fechaSQL);
				
				ps.executeUpdate();
				System.out.println("EJECUTA INSERT");
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
