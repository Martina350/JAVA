package com.cmc.directorio.entidades;

public class AdminContacto {
	public Contacto buscarMasPesado(Contacto c, Contacto c2) {
		if(c2.getPeso() > c.getPeso()) {
			return c2;
		}else if(c.getPeso() > c2.getPeso()) {
			return c;
		}else {
			return null;
		}
	}
	
	public boolean compararOperadoras(Contacto c, Contacto c2) {
		if (c.getTelefono().getOperadora() == c2.getTelefono().getOperadora()) {
			return true;
		}else{
			return false;
		}
	}
	
	public void activarUsuario(Contacto contacto) {
		if(contacto.getTelefono().isTieneWhatsapp() == true) {
			contacto.setActivo(true);
		}
	}
}
