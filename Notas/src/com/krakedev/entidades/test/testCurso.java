package com.krakedev.entidades.test;

import com.krakedev.entidades.Estudiantes;
import com.krakedev.entidades.Curso;
import com.krakedev.entidades.Materia;
import com.krakedev.entidades.Nota;

public class testCurso {

	public static void main(String[] args) {
		 Curso curso1 = new Curso();
		 Materia sociales= new Materia("COD1", "Sociales");
		 Materia matematicas= new Materia("COD2", "Matematicas");
		 Materia lenguaje= new Materia("COD3", "Lenguaje");
		 Materia biologia= new Materia("COD4", "Biologia");
		 Materia quimica= new Materia("COD5", "Quimica");
		 Materia fisica= new Materia("COD6", "Quimica");

		 Estudiantes estudiante = new Estudiantes("Juan", "Perez","1234567890");
		 Estudiantes estudiante2 = new Estudiantes("Juan", "Perez","12345678290");
	     Nota nota1 = new Nota(sociales, 10.0);
	     Nota nota2 = new Nota(matematicas, 10.0);
	     Nota nota3 = new Nota(lenguaje, 10.0);
	     Nota nota4 = new Nota(biologia, 6.0);
	     Nota nota5 = new Nota(quimica, 8.0);
	     Nota nota6 = new Nota(fisica, 9.0);
	     
	     
	     Nota nota11 = new Nota(sociales,5.0);
	     Nota nota12 = new Nota(matematicas, 5.0);
	     Nota nota13 = new Nota(lenguaje, 10.0);
	     Nota nota14 = new Nota(biologia, 8.0);
	     Nota nota15 = new Nota(quimica, 7.0);
	     Nota nota16 = new Nota(fisica, 5.0);
	     
	     
	    
	     estudiante.agregarNota(nota1);
	     estudiante.agregarNota(nota2);
	     estudiante.agregarNota(nota3);
	     estudiante.agregarNota(nota4);
	     estudiante.agregarNota(nota5);
	     estudiante.agregarNota(nota6);

	     
	     estudiante2.agregarNota(nota11);
	     estudiante2.agregarNota(nota12);
	     estudiante2.agregarNota(nota13);
	     estudiante2.agregarNota(nota14);
	     estudiante2.agregarNota(nota15);
	     estudiante2.agregarNota(nota16);

	     curso1.matricularEstudiantes(estudiante);
	     curso1.matricularEstudiantes(estudiante2);
	     
	     System.out.println(curso1.getEstudiantes().size());
	     
	     System.out.println(curso1.calcularPromedioCurso());

	     
	     curso1.mostrar();


	}

}
