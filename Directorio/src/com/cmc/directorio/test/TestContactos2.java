package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContacto;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos2 {
	public static void main(String[] args) {
		Telefono telef=new Telefono();
		Telefono telf=new Telefono();
		
		AdminContacto contacto=new AdminContacto();
		
		telef.setOperadora("movi");
		telef.setNumero("0999070183");
		telf.setOperadora("movi");
		telf.setNumero("0962837277");
		
		Contacto contact;
		boolean operadora;
		
		
		Contacto c2=new Contacto("FLORES",telf,55.7);
		Contacto c=new Contacto("TERAN",telef,55.7);	
		
		c.setTelefono(telef);
		c2.setTelefono(telf);
		
		contact=contacto.buscarMasPesado(c, c2);
		operadora=contacto.compararOperadoras(telef, telf);
		
		c.Imprimir();
		c2.Imprimir();
		
		if (contact==null) {
			System.out.println("PESAN LO MISMO");
		}else {
			System.out.println("EL MAS PESADO ES: "+contact.getApellido());
		}
		
		if(operadora) {
			System.out.println("SON OPERADORAS IGUALES: "+operadora);
		}else {
			System.out.println("NO SON OPERADORAS IGUALES");
		}

	}

}

