package com.krakedev.evaluacion;

public class Telefono {
	private String numero;
	private String tipo;
	private String estado;
	
	public Telefono(String numero, String tipo) {
		this.numero = numero;
		this.tipo = tipo;
		
		if (numero == null || tipo == null) {
	        this.estado = "E";
	    } else if (tipo.equalsIgnoreCase("Movil")) {
	        if (numero.length() == 10) {
	            this.estado = "C";
	        } else {
	            this.estado = "E";
	        }
	    } else if (tipo.equalsIgnoreCase("Convencional")) {
	        if (numero.length() == 7) {
	            this.estado = "C";
	        } else {
	            this.estado = "E";
	        }
	    } else {
	        this.estado = "E";
	    }
	}
		
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
