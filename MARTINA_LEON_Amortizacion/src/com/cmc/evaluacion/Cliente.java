package com.cmc.evaluacion;

public class Cliente {
	private String cedula;
    private String nombre;
    private String apellido;

    public Cliente(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public void mostrarCliente() {
        System.out.printf("Cliente registrado %s %s (cedula-%s, nombre-%s, apellido-%s)%n", 
                nombre, apellido, cedula, nombre, apellido);
    }
}
