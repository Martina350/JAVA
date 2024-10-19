package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Videojuegos;
import com.krakedev.persistencia.servicios.AdminVideojuegos;

public class TestObetenerTodos {

	public static void main(String[] args) {
		 try {
	            ArrayList<Videojuegos> videojuegos = AdminVideojuegos.obtenerTodos();
	            
	            if (videojuegos.isEmpty()) {
	                System.out.println("No se encontraron videojuegos.");
	            } else {
	                for (Videojuegos v : videojuegos) {
	                    System.out.println("Videojuego: " + v.getNombre() + ", Código: " + v.getCodigo());
	                }
	            }
	        } catch (Exception e) {
	           System.out.println(e.getMessage());
	        }

	}

}
