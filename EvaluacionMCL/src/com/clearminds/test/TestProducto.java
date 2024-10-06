package com.clearminds.test;

import com.clearminds.componentes.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto producto1= new Producto("Papitas",0.85,"KE34");
		
		System.out.println("CODIGO: "+producto1.getCodigo());
		System.out.println("NOMBRE: "+producto1.getNombre());
		System.out.println("PRECIO: "+producto1.getPrecio());
		System.out.println("*******************************");
		System.out.println("NUEVO PRECIO: "+producto1.disminuirPrecio(1.75));
		System.out.println("PRECIO INCREMENTADO: "+producto1.incrementarPrecio(0.50));
		System.out.println("PRECIO INCREMENTADO: "+producto1.incrementarPrecio(0.15));

	}

}
