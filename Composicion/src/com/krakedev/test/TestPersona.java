package com.krakedev.test;

import com.krakedev.composicion.Direccion;
import com.krakedev.composicion.Persona;

public class TestPersona {

	public static void main(String[] args) {
		Persona p1=new Persona();
		
		p1.setNombre("PEDRO");
		p1.setApellido("MENDEZ");
		Direccion dir=new Direccion();
		dir.setCallePrincipal("AV.SIMON BOLIVAR");
		dir.setCalleSecundaria("AV.ELOY ALFARO");
		dir.setNumero("N-36");
		p1.setDireccion(dir);
		
		
		String nombre=p1.getNombre();
		Direccion d1=p1.getDireccion();
		
		System.out.println("NOMBRE: "+nombre);
		//d1 esta null, error cuando la variable esta null y trata de invocar un metodo con esa variable
		System.out.println(d1.getCallePrincipal());
						// null.algunMetodo(); 
		p1.imprimir();
		
		Persona p2=new Persona();
		p2.setNombre("DAYANNARA");
		p2.imprimir();
		Direccion d2=new Direccion ("AV.SHYRIS","AV.ELOY ALFARO","S/N");
		p2.setDireccion(d2);
		System.out.println("FIN");
		Persona p3=new Persona();
		p3.setDireccion(new Direccion("xx","yy","123"));
		
		p3.imprimir();
		System.out.println("FIN");
	}

}
