package com.krakedev.controlflujo;

public class Validador {
	public void validarEdad(int edad) {
		if(edad>=18) {
			System.out.println("ES MAYOR DE EDAD");
		}else if(edad >= 12 && edad < 18) {
			System.out.println("ES ADOLESCENTE");
		}else if (edad>0 && edad <12) {
			System.out.println("ES INFANTE");
		}else {
			System.out.println("EDAD INCORRECTA");
		}
	}
}
