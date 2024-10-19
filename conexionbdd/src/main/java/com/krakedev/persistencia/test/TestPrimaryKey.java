package com.krakedev.persistencia.test;

import com.krakedev.persistencia.entidades.Videojuegos;
import com.krakedev.persistencia.servicios.AdminVideojuegos;

public class TestPrimaryKey {

	public static void main(String[] args) {
		  try {
	            int codigo = 5;
	            Videojuegos videojuego = AdminVideojuegos.buscarPorCodigo(codigo);
	            
	            if (videojuego != null) {
	                System.out.println("Videojuego encontrado: " + videojuego.getNombre());
	            } else {
	                System.out.println("No se encontró ningún videojuego con el código: " + codigo);
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	}

}
