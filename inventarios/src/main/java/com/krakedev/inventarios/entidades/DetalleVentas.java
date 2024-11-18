package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class DetalleVentas {
	private int codigo;
	private CabeceraVenta cabeceraVenta;
	private Producto producto;
	private int cantidad;
	private BigDecimal precioVenta;
	private BigDecimal subtotal;
	private BigDecimal subtotalIva;
	
	@Override
	public String toString() {
		return "DetalleVentas [codigo=" + codigo + ", cabeceraVenta=" + cabeceraVenta + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", subtotal=" + subtotal
				+ ", subtotalIva=" + subtotalIva + "]";
	}
	public DetalleVentas() {
		super();
	}
	public DetalleVentas(int codigo, CabeceraVenta cabeceraVenta, Producto producto, int cantidad,
			BigDecimal precioVenta, BigDecimal subtotal, BigDecimal subtotalIva) {
		super();
		this.codigo = codigo;
		this.cabeceraVenta = cabeceraVenta;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.subtotal = subtotal;
		this.subtotalIva = subtotalIva;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public CabeceraVenta getCabeceraVenta() {
		return cabeceraVenta;
	}
	public void setCabeceraVenta(CabeceraVenta cabeceraVenta) {
		this.cabeceraVenta = cabeceraVenta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getSubtotalIva() {
		return subtotalIva;
	}
	public void setSubtotalIva(BigDecimal subtotalIva) {
		this.subtotalIva = subtotalIva;
	}

	
}
