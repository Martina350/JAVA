package com.cmc.evaluacion;

import com.cmc.evaluacion.Prestamo;
import java.util.ArrayList;

public class Cliente {
	private String cedula;
    private String nombre;
    private String apellido;
    private ArrayList<Prestamo> prestamos;

    public Cliente(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.prestamos=new ArrayList<Prestamo>();
    }

    public String getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Prestamo prestamo) {
		this.prestamos.add(prestamo);
	}
    public void mostrarCliente() {
        System.out.printf("Cliente registrado %s %s (cedula-%s, nombre-%s, apellido-%s)%n", 
                nombre, apellido, cedula, nombre, apellido);
    }
}
