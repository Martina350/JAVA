package com.krakedev.persistencia.test;

import com.krakedev.persistencia.servicios.AdminVideojuegos;

public class TestEliminar {

	public static void main(String[] args) {
		try {
            AdminVideojuegos.eliminar("14");
            System.out.println("VIDEOJUEGO ELIMINADO EXITOSAMENTE");
        } catch (Exception e) {
            System.out.println("ERROR EN EL SISTEMA: " + e.getMessage());
        }	

	}

}
