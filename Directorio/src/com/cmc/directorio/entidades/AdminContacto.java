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
	
	public boolean compararOperadoras(Telefono telef, Telefono telf) {
		if (telef.getOperadora() == telf.getOperadora()) {
			return true;
		}else{
			return false;
		}
	}
	
	public void activarUsuario(Telefono telef, Contacto c) {
		if(telef.isTieneWhatsapp()==true) {
			c.setActivo(true);
		}else {
			c.setActivo(false);
		}
	}
	

}
