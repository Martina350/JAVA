package com.krakedev.evaluacion.entidades;

import java.util.Date;

public class HistorialMovimientos {
	private int id;
    private String idProducto;
    private int cantidad;
    private Date fechaMovimiento;
    
    @Override
	public String toString() {
		return "HistorialMovimientos [id=" + id + ", idProducto=" + idProducto + ", cantidad=" + cantidad
				+ ", fechaMovimiento=" + fechaMovimiento + "]";
	}

	public HistorialMovimientos() {
    	
    }    
    
	public HistorialMovimientos(int id, String idProducto, int cantidad, Date fechaMovimiento) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.fechaMovimiento = fechaMovimiento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
    
    
}
