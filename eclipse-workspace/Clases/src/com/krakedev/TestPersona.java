package com.krakedev;

public class TestPersona {

	public static void main(String[] args) {
		Persona p; //Declaro una variable llamada p de tipo persona
		Persona p2=new Persona();
		p=new Persona ();//Instanciar un objeto Persona, referenciarlo con p
		//Accedo a los atributos
		System.out.println("nombre:"+p.nombre);
		System.out.println("edad:"+p.edad);
		System.out.println("estatura:"+p.estatura);
		//Modificar los atributos
		p.nombre="Mario";
		p.edad=45;
		p.estatura=1.56;
		//Acceder a los atributos
		System.out.println("------");
		System.out.println("nombre:"+p.nombre);
		System.out.println("edad:"+p.edad);
		System.out.println("estatura:"+p.estatura);
		//Modificar los atributos
		p2.nombre="Angelina";
		p2.edad=30;
		p2.estatura=1.55;
		//Acceder a los atributos
		System.out.println("------");
		System.out.println("p2.nombre: "+p2.nombre);
		System.out.println("p2.edad: "+p2.edad);
		System.out.println("p2.estatura: "+p2.estatura);
	}

}
