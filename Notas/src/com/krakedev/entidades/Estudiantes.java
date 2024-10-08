package com.krakedev.entidades;

import java.util.ArrayList;

public class Estudiantes {
	private String nombre;
	private String apellido;
	private String cedula;
	ArrayList<Nota> notas;
	
	
	
	public Estudiantes(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	
	public Estudiantes(String nombre, String apellido, String cedula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.notas = new ArrayList<>();
	}


	public Estudiantes() {
		notas = new ArrayList<>();
	}
	
	public void agregarNota(Nota nuevaNota) {
	    for (int i = 0; i < notas.size(); i++) {
	        if (notas.get(i).getMateria().equals(nuevaNota.getMateria())) {
	        }
	    }
	    if (nuevaNota.getCalificacion() < 0 || nuevaNota.getCalificacion() > 10) {
	    }
	    notas.add(nuevaNota);
	}
	
	public void modificarNota(String codigo, double nuevaNota) {
		 if (nuevaNota < 0 || nuevaNota > 10) {
		        System.out.println("La calificación debe estar entre 0 y 10");
		        return;
		 }
		 for (int i = 0; i < notas.size(); i++) {
		    if (notas.get(i).getMateria().equals(codigo)) {
		        notas.get(i).setCalificacion(nuevaNota);
		     }
		 }
		 System.out.println("No se encontró una materia con el código proporcionado");
	}
	
	public double calcularPromedioNotasEstudiante() {
	    double suma = 0;
	    for (int i = 0; i < notas.size(); i++) {
	        suma += notas.get(i).getCalificacion();
	    }
	    double promedio = suma / notas.size();
	    return promedio;
	}
	
	public void mostrar() { 
		StringBuilder informacion=new StringBuilder();
		informacion.append("Estudiantes [nombre="+ nombre +",apellido="+apellido+",cedula="+cedula+",nombre="+nombre+"]  " );
	    for (int i = 0; i < notas.size(); i++) {
	        Nota nota = notas.get(i);
	        informacion.append("Estudiantes [materia="+nota.getMateria().getNombre()+",calificacion="+nota.getCalificacion()+"]" );
	    }
	    System.out.println(informacion.toString());
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
	
	
}
