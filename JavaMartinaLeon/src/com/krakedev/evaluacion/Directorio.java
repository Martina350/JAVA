package com.krakedev.evaluacion;

import java.util.ArrayList;
import java.util.Date;

public class Directorio {
	private ArrayList<Contacto> contactos;
    private Date fechaModificacion;
    
    public Directorio() {
        this.contactos = new ArrayList<>();
        this.fechaModificacion = new Date(); 
    }

    public boolean agregarContacto(Contacto contacto) {
        if (contacto != null) {
        	 if (buscarPorCedula(contacto.getCedula()) == null) {
        		 contactos.add(contacto);
        		 fechaModificacion = new Date(); 
        		 return true; 
        	 }else {
        		 return false;
        	 }   
        }
        return false; 
    }

    public Contacto buscarPorCedula(String cedula) {
        for (int i = 0; i < contactos.size(); i++) {
        	  Contacto contacto = contactos.get(i);
        	if (contacto.getCedula().equals(cedula)) {
                return contacto; 
            }
        }
        return null; 
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }
}
