package com.krakedev.excepciones;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio3 {
	private static final Logger LOGGER = LogManager.getLogger(Ejercicio3.class);
	
	public void metodo1(){
		String a=null;
		try {
			a.substring(0);
		}catch(Exception io){
			System.out.println("ERROR");
			LOGGER.error("ERROR AL OBTENER LA SUBCADENA",io);
		}
		
	}
	public static void main(String[] args) {
		Ejercicio3 ej3= new Ejercicio3();
		ej3.metodo1();
	}
}
