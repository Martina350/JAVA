package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;
import com.krakedev.persistencia.entidades.Prestamo;
import com.krakedev.persistencia.servicios.AdminPrestamo;
import com.krakedev.persistencia.utils.Convertidor;

public class TestAdminPrestamo {
	public static void main(String[] args) {
	 Prestamo prestamo = new Prestamo();
	 prestamo.setCedula("1726312745");
     prestamo.setMonto(new BigDecimal(300.00));
     prestamo.setGarante("Martina");
	 
     try {

         Date fechaPrestamo = Convertidor.convertirFecha("2024/05/06");
         prestamo.setFechaPrestamo(fechaPrestamo);

         Date horaPrestamo = Convertidor.convertirHora("10:30:05");
         prestamo.setHoraPrestamo(horaPrestamo);


         AdminPrestamo.insertar(prestamo);
     } catch (Exception e) {
         System.out.println("ERROR EN EL SISTEMA: " + e.getMessage());
     }

	}
}
