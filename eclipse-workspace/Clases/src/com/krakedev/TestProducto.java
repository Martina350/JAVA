package com.krakedev;

public class TestProducto {

	public static void main(String[] args) {
		Producto productoA=new Producto();
		Producto productoB=new Producto();
		Producto productoC=new Producto();
		
		productoA.nombre="Aspirina";
		productoA.descripcion="Pastillas";
		productoA.precio=14.99;
		productoA.stockAnual=189;
		
		System.out.println("------");
		System.out.println("nombre:"+productoA.nombre);
		System.out.println("descripcion:"+productoA.descripcion);
		System.out.println("precio:"+productoA.precio);
		System.out.println("stockAnual:"+productoA.stockAnual);
		
		productoB.nombre="Buprex";
		productoB.descripcion="Jarabe";
		productoB.precio=12.55;
		productoB.stockAnual=145;
		
		System.out.println("------");
		System.out.println("nombre:"+productoB.nombre);
		System.out.println("descripcion:"+productoB.descripcion);
		System.out.println("precio:"+productoB.precio);
		System.out.println("stockAnual:"+productoB.stockAnual);
		
		productoC.nombre="Eucamiel";
		productoC.descripcion="Jarabe";
		productoC.precio=8.55;
		productoC.stockAnual=125;
		
		System.out.println("------");
		System.out.println("nombre:"+productoC.nombre);
		System.out.println("descripcion:"+productoC.descripcion);
		System.out.println("precio:"+productoC.precio);
		System.out.println("stockAnual:"+productoC.stockAnual);
	}

}
