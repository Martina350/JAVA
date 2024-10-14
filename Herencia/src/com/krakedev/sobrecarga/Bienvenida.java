package com.krakedev.sobrecarga;

public class Bienvenida {
	public void saludar(String nombre) {
		System.out.println("HOLA"+nombre);
	}
	public void saludar(String nombre, String apellido) {
		System.out.println("HOLA "+nombre+" "+apellido);
	}
}
