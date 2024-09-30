package com.cmc.repaso.entidades;

public class Item {
	private String nombre;
	private int productosActuales;
	private int productosDevueltos;
	private int productosVendidos;
	
	public void imprimir () {
	    System.out.println("NOMBRE DEL PRODUCTO: "+nombre);
	    System.out.println("PRODUCTOS ACTUALES: "+productosActuales);
	    System.out.println("PRODUCTOS DEVUELTOS: "+productosDevueltos);
	    System.out.println("PRODUCTOS VENDIDOS: "+productosVendidos);
	}
	
	public void vender(int cantidadVendida) {
		if (cantidadVendida <= productosActuales) {
            productosActuales -= cantidadVendida;
            productosVendidos += cantidadVendida;
        } else {
            System.out.println("NO HAY SUFICIENTE CANTIDAD DE PRODUCTOS");
        }
	}
	
	public void devolver(int cantidadDevuelta) {
        if (cantidadDevuelta <= productosVendidos) {
            productosActuales += cantidadDevuelta;
            productosVendidos -= cantidadDevuelta;
            productosDevueltos += cantidadDevuelta;
        } else {
            System.out.println("La cantidad devuelta no puede exceder los productos vendidos.");
        }
    }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getProductosActuales() {
		return productosActuales;
	}
	public void setProductosActuales(int productosActuales) {
		this.productosActuales = productosActuales;
	}
	public int getProductosDevueltos() {
		return productosDevueltos;
	}
	public void setProductosDevueltos(int productosDevueltos) {
		this.productosDevueltos = productosDevueltos;
	}
	public int getProductosVendidos() {
		return productosVendidos;
	}
	public void setProductosVendidos(int productosVendidos) {
		this.productosVendidos = productosVendidos;
	}
	
	
}
