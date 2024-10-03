package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContacto;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos1 {

	public static void main(String[] args) {
		Telefono telef=new Telefono();
		Telefono telf=new Telefono();
		
		AdminContacto contacto=new AdminContacto();
		
		telef.setOperadora("movi");
		telef.setNumero("0999070183");
		telf.setOperadora("tuenti");
		telf.setNumero("0962837277");
		
		Contacto contact;
		Contacto c2=new Contacto("FLORES",telf,59.7);
		Contacto c=new Contacto("TERAN",telef,67.6);	
		
		c.setTelefono(telef);
		c2.setTelefono(telf);
		
		contact=contacto.buscarMasPesado(c, c2);
		boolean sonIguales=contacto.compararOperadoras(c, c2);
		
		c.Imprimir();
		c2.Imprimir();
		
		if (contact==null) {
			System.out.println("SON IGUALES");
		}else {
			System.out.println("EL MAS PESADO ES: "+contact.getApellido());
		}
		
		if(sonIguales) {
			System.out.println("SON OPERADORAS IGUALES: "+contact.getTelefono().getOperadora());
		}else {
			System.out.println("NO SON OPERADORAS IGUALES");
		}

	}

}
