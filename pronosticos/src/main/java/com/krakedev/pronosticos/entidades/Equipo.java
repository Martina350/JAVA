package com.krakedev.pronosticos.entidades;

public class Equipo {
	private int id;
    private String codigo;
    private int codigoNum;
    private String nombre;
	@Override
	public String toString() {
		return "Equipo [id=" + id + ", codigo=" + codigo + ", codigoNum=" + codigoNum + ", nombre=" + nombre + "]";
	}
	public Equipo() {
		super();
	}
	public Equipo(int id, String codigo, int codigoNum, String nombre) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.codigoNum = codigoNum;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getCodigoNum() {
		return codigoNum;
	}
	public void setCodigoNum(int codigoNum) {
		this.codigoNum = codigoNum;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    
}
