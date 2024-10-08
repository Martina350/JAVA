package com.krakedev.entidades;

import java.util.ArrayList;

public class Curso {
	ArrayList<Estudiantes> estudiantes;
	
	public ArrayList<Estudiantes> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiantes> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Curso() {
		estudiantes = new ArrayList<>();
	}

	public String buscarEstudiantePorCedula(Estudiantes estudiante) {
	    for (int i = 0; i < estudiantes.size(); i++) {
	       if (estudiantes.get(i).getCedula().equals(estudiante.getCedula())) {
	           return "El estudiante con cédula " + estudiante.getCedula() + " ya está en el curso.";
	       }
	    }
	    return null;
	}
	
	public void matricularEstudiantes(Estudiantes estudiante) {
        if (buscarEstudiantePorCedula(estudiante) == null) {
            estudiantes.add(estudiante);
            System.out.println("Estudiante con cédula " + estudiante.getCedula() + " matriculado correctamente.");
        } else {
            System.out.println("El estudiante ya está matriculado.");
        }
    }
	
	public double calcularPromedioCurso() {
        double sumaPromedios = 0.0;
        for (int i = 0; i < estudiantes.size(); i++) {
            double promedioEstudiante = estudiantes.get(i).calcularPromedioNotasEstudiante();
            sumaPromedios += promedioEstudiante;
        }
        double promedioCurso = sumaPromedios / estudiantes.size();
        return promedioCurso;
    }
	
	  public void mostrar() {
		  	StringBuilder informacion=new StringBuilder();
	        for (int i = 0; i < estudiantes.size(); i++) {
	            informacion.append("Estudiantes [nombre="+estudiantes.get(i).getNombre()+",apellido="+estudiantes.get(i).getApellido()+",cedula="+estudiantes.get(i).getCedula()+",materia="+estudiantes.get(i).getNotas().get(i).getMateria().getNombre()+",calificacion="+estudiantes.get(i).calcularPromedioNotasEstudiante()+"]");
	        }
	        System.out.println(informacion.toString());
	    }
	
}
