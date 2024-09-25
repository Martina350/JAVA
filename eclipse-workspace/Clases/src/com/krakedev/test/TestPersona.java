package com.krakedev.test;

import com.krakedev.Persona;

public class TestPersona {

	public static void main(String[] args) {
		Persona p; //Declaro una variable llamada p de tipo persona
		Persona p2=new Persona();
		Persona p3=new Persona("Pablo");
		Persona p4=new Persona("Juan",43,1.60);
		
		System.out.println("nombre:"+p3.getNombre());
		System.out.println("nombre:"+p4.getNombre());
		System.out.println("edad:"+p4.getEdad());
		System.out.println("estatura:"+p4.getEstatura());
		p=new Persona ();//Instanciar un objeto Persona, referenciarlo con p
		//Accedo a los atributos
		System.out.println("nombre:"+p.getNombre());
		System.out.println("edad:"+p.getEdad());
		System.out.println("estatura:"+p.getEstatura());
		//Modificar los atributos
		p.setNombre("Mario");
		p.setEdad(45);
		p.setEstatura(1.56);
		//Acceder a los atributos
		System.out.println("------");
		System.out.println("nombre:"+p.getNombre());
		System.out.println("edad:"+p.getEdad());
		System.out.println("estatura:"+p.getEstatura());
		//Modificar los atributos
		p2.setNombre("Angelina");
		p2.setEdad(30);
		p2.setEstatura(1.55);
		//Acceder a los atributos
		System.out.println("------");
		System.out.println("nombre:"+p2.getNombre());
		System.out.println("edad:"+p2.getEdad());
		System.out.println("estatura:"+p2.getEstatura());
	}

}
