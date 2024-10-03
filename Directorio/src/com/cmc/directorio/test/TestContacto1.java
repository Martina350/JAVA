package com.cmc.directorio.test;

import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContacto1 {

	public static void main(String[] args) {
		Telefono telef=new Telefono();
		Telefono telf=new Telefono();
		telef.setOperadora("movi");
		telef.setNumero("0999070183");
		telf.setOperadora("tuenti");
		telf.setNumero("0962837277");
		Contacto c2=new Contacto("LEON",telf,59.7);
		Contacto c=new Contacto("CAMPOVERDE",telef,67.6);	
		c.setTelefono(telef);
		c.Imprimir();
		c2.Imprimir();
	}

}
