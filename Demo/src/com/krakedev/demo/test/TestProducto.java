package com.krakedev.demo.test;

import com.krakedev.demo.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto producto1= new Producto(523,"Manzana");
		
		producto1.setDescripcion("Organica");
		producto1.setPeso(0.8);
		
		System.out.println("CODIGO DEL PRODUCTO: "+producto1.getCodigo());
		System.out.println("NOMBRE DEL PRODUCTO: "+producto1.getNombre());
		System.out.println("DESCRIPCION: "+producto1.getDescripcion());
		System.out.println("PESO: "+producto1.getPeso());
	}

}
