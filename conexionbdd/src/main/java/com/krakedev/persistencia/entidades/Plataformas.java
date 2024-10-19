package com.krakedev.persistencia.entidades;

public class Plataformas {
	private int idPlataforma;
	private String nombrePlataforma;
	private int codigoVideojuego;
	
	
	
	@Override
	public String toString() {
		return "Plataformas [idPlataforma=" + idPlataforma + ", nombrePlataforma=" + nombrePlataforma
				+ ", codigoVideojuego=" + codigoVideojuego + "]";
	}
	
	public Plataformas() {
		
	}
	
	public Plataformas(int idPlataforma, String nombrePlataforma, int codigoVideojuego) {
		super();
		this.idPlataforma = idPlataforma;
		this.nombrePlataforma = nombrePlataforma;
		this.codigoVideojuego = codigoVideojuego;
	}


	public int getIdPlataforma() {
		return idPlataforma;
	}


	public void setIdPlataforma(int idPlataforma) {
		this.idPlataforma = idPlataforma;
	}


	public String getNombrePlataforma() {
		return nombrePlataforma;
	}


	public void setNombrePlataforma(String nombrePlataforma) {
		this.nombrePlataforma = nombrePlataforma;
	}


	public int getCodigoVideojuego() {
		return codigoVideojuego;
	}


	public void setCodigoVideojuego(int codigoVideojuego) {
		this.codigoVideojuego = codigoVideojuego;
	}
	
	
	
}
