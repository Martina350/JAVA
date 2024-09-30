package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Estudiante;

public class TestEstudiante {

	public static void main(String[] args) {
		Estudiante estudiante1=new Estudiante("DAYANNARA");
		Estudiante estudiante2=new Estudiante("MARTINA");
		
		estudiante1.calificar(9.5);
		estudiante2.calificar(5.5);
		
		System.out.println("RESULTADO: " +estudiante1.getResultado());
		System.out.println("RESULTADO: " +estudiante2.getResultado());
	}

}
