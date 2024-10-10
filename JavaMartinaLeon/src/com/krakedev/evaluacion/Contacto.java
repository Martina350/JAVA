package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Contacto {
	private String cedula;
	private String nombre;
	private String apellido;
	private Direccion direccion;
	private ArrayList<Telefono> telefonos;
	
	public void imprimir2() {
        System.out.println("Información del Contacto:");
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Dirección:");
        if (direccion != null) {
            System.out.println("  Calle Principal: " + direccion.getCallePrincipal());
            System.out.println("  Calle Secundaria: " + direccion.getCalleSecundaria());
        } else {
            System.out.println("  Dirección no asignada");
        }
    }
	
	public void imprimir() {
        System.out.println("***"+ nombre +" "+apellido+"***");
        if (direccion != null) {
            System.out.println("Dirección: " + direccion.getCallePrincipal()+ " y " + direccion.getCalleSecundaria());
        } else {
            System.out.println("No tiene asociada una direccion");
        }
        mostrarTelefonos();
    }
	
	public void agregarTelefono(Telefono telefono) {
		telefonos.add(telefono);
	}
	
	public void mostrarTelefonos() {
        System.out.println("Telefonos con estado'C': ");
        for (Telefono telefono : telefonos) {
            if ("C".equals(telefono.getEstado())) {
                System.out.println("Número: " + telefono.getNumero() + ", Tipo: "+ telefono.getTipo());
            }
        }
    }

	public ArrayList<Telefono> recuperarIncorrectos() {
        ArrayList<Telefono> telefonosIncorrectos = new ArrayList<>();
        for (int i = 0; i < telefonos.size(); i++) {
            Telefono telefono = telefonos.get(i);
            if ("E".equals(telefono.getEstado())) {
                telefonosIncorrectos.add(telefono);
            }
        }
        return telefonosIncorrectos;
    }
	
	public Contacto(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefonos = new ArrayList<>(); 
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
}
