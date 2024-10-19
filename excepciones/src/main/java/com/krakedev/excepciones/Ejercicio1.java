package com.krakedev.excepciones;

public class Ejercicio1 {

	public static void main(String[] args) {
		System.out.println("INICIO");
		String a= "ssssssss";
		try {
			a.substring(3);	
			System.out.println("ABRE CONEXION A LA BASE DE DATOS");
		}catch(Exception ex){
			System.out.println("ENTRA AL CATCH");
		}finally {
			System.out.println("ENTRA AL FINALLY");
			System.out.println("CIERRA CONEXION A LA BASE DE DATOS");
		}
		System.out.println("FUERA DEL CATCH");
	} 

}
