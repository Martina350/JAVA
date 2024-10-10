package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
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
    
    public String consultarUltimaModificacion() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(fechaModificacion);
    }
    
    public int contarPerdidos() {
        int perdidos = 0;
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);
            if (contacto.getDireccion() == null) {
                perdidos++;
            }
        }
        return perdidos;
    }
    
    public int contarFijos() {
        int count = 0; 
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);
            ArrayList<Telefono> telefonos = contacto.getTelefonos();
            for (int j = 0; j < telefonos.size(); j++) {
                Telefono telefono = telefonos.get(j);
                if (telefono.getTipo().equals("Convencional") && telefono.getEstado().equals("C")) {
                    count++; 
                }
            }
        }
        return count;
    }
    
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }
}
