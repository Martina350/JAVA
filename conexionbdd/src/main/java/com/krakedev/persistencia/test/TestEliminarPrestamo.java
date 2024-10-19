package com.krakedev.persistencia.test;

import com.krakedev.persistencia.servicios.AdminPrestamo;

public class TestEliminarPrestamo {
	 public static void main(String[] args) {
	        try {
	            AdminPrestamo.eliminar("1234567890");
	            System.out.println("PRESTAMO ELIMINADO EXITOSAMENTE");
	        } catch (Exception e) {
	            System.out.println("ERROR EN EL SISTEMA: " + e.getMessage());
	        }
	    }
}
