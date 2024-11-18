package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class CabeceraVenta {
	private int codigo;
	private Date fecha;
	private BigDecimal subtotal;
	private BigDecimal iva;
	private BigDecimal total;
	
	private ArrayList <DetalleVentas> detalles;
	
	public ArrayList<DetalleVentas> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<DetalleVentas> detalles) {
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "CabeceraVenta [codigo=" + codigo + ", fecha=" + fecha + ", subtotal=" + subtotal + ", iva=" + iva
				+ ", total=" + total + "]";
	}
	public CabeceraVenta() {
		super();
	}
	public CabeceraVenta(int codigo, Date fecha, BigDecimal subtotal, BigDecimal iva, BigDecimal total) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getIva() {
		return iva;
	}
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
}
