package com.krakedev.colecciones;

import java.util.ArrayList;

public class Ejercicio2 {

	public static void main(String[] args) {
		ArrayList<Persona> personas;
		personas= new ArrayList<Persona>();
		
		//Persona p1=new Persona("xx","yy");
		//forma de Instansiar un objeto
		personas.add(new Persona("Leo","Messi"));
		personas.add(new Persona("Taylor","Swift"));
		personas.add(new Persona("Angie","Velasco"));
		
		System.out.println(personas.size());
		
		Persona elementoPersona;
		for(int i=0; i<personas.size();i++) {
			elementoPersona=personas.get(i);
			System.out.println(elementoPersona.getNombre()+" "+elementoPersona.getApellido());
		}
		
	}

}
