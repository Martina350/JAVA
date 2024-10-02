package com.cmc.directorio.entidades;

public class AdminTelefono {
	public void activarMensajeria(Telefono telf) {
        if (telf.getOperadora() == "movi") {
           telf.setTieneWhatsapp(true); 
        }
    }
}
