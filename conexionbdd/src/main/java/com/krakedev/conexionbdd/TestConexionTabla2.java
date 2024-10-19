package com.krakedev.conexionbdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexionTabla2 {

	public static void main(String[] args) {
		PreparedStatement ps=null;
		Connection connection=null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Brownie05");
			System.out.println("CONEXION EXITOSA");
			ps=connection.prepareStatement("insert into prestamo (cedula, monto, fecha_prestamo,hora_prestamo,garante)"
					+ "values(?,?,?,?,?)");
			ps.setString(1, "1726312745");
	        ps.setBigDecimal(2, new BigDecimal (300.00));
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechaStr="2024/05/06 10:30:05";
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
				
				ps.setDate(3, fechaSQL);
				ps.setTime(4, timeSQL);
				ps.setString(5, "martina");
				
				
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
