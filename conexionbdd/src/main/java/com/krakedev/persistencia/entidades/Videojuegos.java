package com.krakedev.persistencia.entidades;

import java.util.Date;

public class Videojuegos {
	private int codigo;
	private String nombre;
	private String descripcion;
	private int valoracion;
	private Plataformas codigoPlataforma;
	private Date fechaPublicacion;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	public Plataformas getCodigoPlataforma() {
		return codigoPlataforma;
	}
	public void setCodigoPlataforma(Plataformas codigoPlataforma) {
		this.codigoPlataforma = codigoPlataforma;
	}
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public Videojuegos() {
		
	}
	
	public Videojuegos(int codigo, String nombre, String descripcion, int valoracion, Plataformas codigoPlataforma) {
	    super();
	    this.codigo = codigo;
	    this.nombre = nombre;
	    this.descripcion = descripcion;
	    this.valoracion = valoracion;
	    this.codigoPlataforma = codigoPlataforma;
	}
	
	
}
