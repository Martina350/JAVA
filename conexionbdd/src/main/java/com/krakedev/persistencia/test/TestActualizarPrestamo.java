package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import com.krakedev.persistencia.entidades.Prestamo;
import com.krakedev.persistencia.servicios.AdminPrestamo;
import com.krakedev.persistencia.utils.Convertidor;

public class TestActualizarPrestamo {

	public static void main(String[] args) {
	      try {
	            Prestamo prestamo = new Prestamo();
	            prestamo.setCedula("1234567890");
	            prestamo.setMonto(new BigDecimal(6000));
	            prestamo.setFechaPrestamo(new java.sql.Date(Convertidor.convertirFecha("2024/10/20").getTime()));
	            prestamo.setHoraPrestamo(new Time(new Date().getTime()));
	            prestamo.setGarante("Pedro López");

	            AdminPrestamo.actualizar(prestamo);
	            System.out.println("PRESTAMO ACTUALIZADO EXITOSAMENTE");
	        } catch (Exception e) {
	            System.out.println("ERROR EN EL SISTEMA: " + e.getMessage());
	        }

	}

}
