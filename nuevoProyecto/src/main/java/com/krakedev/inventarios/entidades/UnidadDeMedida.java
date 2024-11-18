package com.krakedev.inventarios.entidades;

public class UnidadDeMedida {
	private String codigoUdm;
	private CategoriaUDM categoriaUdm;
	private String descripcion;
	
	@Override
	public String toString() {
		return "UnidadDeMedida [codigoUdm=" + codigoUdm + ", categoriaUdm=" + categoriaUdm + ", descripcion="
				+ descripcion + "]";
	}
	public UnidadDeMedida() {
		super();
	}
	public UnidadDeMedida(String codigoUdm, CategoriaUDM categoriaUdm, String descripcion) {
		super();
		this.codigoUdm = codigoUdm;
		this.categoriaUdm = categoriaUdm;
		this.descripcion = descripcion;
	}
	public String getCodigoUdm() {
		return codigoUdm;
	}
	public void setCodigoUdm(String codigoUdm) {
		this.codigoUdm = codigoUdm;
	}
	public CategoriaUDM getCategoriaUdm() {
		return categoriaUdm;
	}
	public void setCategoriaUdm(CategoriaUDM categoriaUdm) {
		this.categoriaUdm = categoriaUdm;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
