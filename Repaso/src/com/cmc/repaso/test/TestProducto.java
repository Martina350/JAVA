package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto producto1=new Producto("LAPTOP",1000.00);
		producto1.setPrecio(-1000.00);
		System.out.println("VALOR: "+producto1.getPrecio());
		System.out.println("PRECIO CON DESCUENTO: "+producto1.calcularPrecioPromo(50));
	}

}
