package com.krakedev;

public class TestProducto {

	public static void main(String[] args) {
		Producto productoA=new Producto();
		Producto productoB=new Producto();
		Producto productoC=new Producto();
		
		productoA.setNombre("Aspirina");
		productoA.setDescripcion("Pastillas");
		productoA.setPrecio(14.99);
		productoA.setStockAnual(189);
		
		System.out.println("------");
		System.out.println("nombre:"+productoA.getNombre());
		System.out.println("descripcion:"+productoA.getDescripcion());
		System.out.println("precio:"+productoA.getPrecio());
		System.out.println("stockAnual:"+productoA.getStockAnual());
		
		productoB.setNombre("Buprex");
		productoB.setDescripcion("Jarabe");
		productoB.setPrecio(12.55);
		productoB.setStockAnual(145);
		
		System.out.println("------");
		System.out.println("nombre:"+productoB.getNombre());
		System.out.println("descripcion:"+productoB.getDescripcion());
		System.out.println("precio:"+productoB.getPrecio());
		System.out.println("stockAnual:"+productoB.getStockAnual());
		
		productoC.setNombre("Eucamiel");
		productoC.setDescripcion("Jarabe");
		productoC.setPrecio(8.55);
		productoC.setStockAnual(125);
		
		System.out.println("------");
		System.out.println("nombre:"+productoC.getNombre());
		System.out.println("descripcion:"+productoC.getDescripcion());
		System.out.println("precio:"+productoC.getPrecio());
		System.out.println("stockAnual:"+productoC.getStockAnual());
	}

}
