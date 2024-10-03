package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContacto;
import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestActivos {

	public static void main(String[] args) {
		Telefono telef=new Telefono("claro", "0965478392",20);
		Contacto c=new Contacto("TERAN",telef,55.7);
		telef.setOperadora("movi");
		c.setTelefono(telef);
			
		AdminContacto contacto=new AdminContacto();
		AdminTelefono telefono=new AdminTelefono();
		
		contacto.activarUsuario(telef, c);
		telefono.activarMensajeria(telef);
		
		System.out.println("OPERADORA: "+ telef.getOperadora());
		System.out.println("CONTACTO: "+ c.getApellido());
		System.out.println("NUMERO: "+ telef.getNumero());
		System.out.println("WHATSAPP: "+ telef.isTieneWhatsapp());
		System.out.println("PESO: "+ c.getPeso());
		System.out.println("CONTACTO ACTIVO: "+ c.isActivo());
	}

}
