package com.cmc.directorio.entidades;

public class Contacto {
	private String apellido;
	private boolean activo;
	private Telefono telefono;
	private double peso;
	
	public void Imprimir() {
		System.out.println("CONTACTO: "+apellido);
		System.out.println("OPERADORA: "+telefono.getOperadora());
		System.out.println("N.CELULAR: "+telefono.getNumero());
		System.out.println("PESO: "+peso);
		System.out.println("--------------------------------------");
	}
	
	public Contacto(String apellido, Telefono telefono, double peso) {
		this.apellido = apellido;
		this.telefono = telefono;
		this.peso = peso;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Telefono getTelefono() {
		return telefono;
	}
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
