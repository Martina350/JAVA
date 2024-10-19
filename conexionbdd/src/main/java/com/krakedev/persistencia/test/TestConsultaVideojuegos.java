package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Videojuegos;
import com.krakedev.persistencia.servicios.AdminVideojuegos;

public class TestConsultaVideojuegos {

	public static void main(String[] args) {
		try {
			ArrayList<Videojuegos> videojuegos=AdminVideojuegos.buscarPorNombre("a");
			System.out.println(videojuegos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
