package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {
		 Item producto1 = new Item();
	        producto1.setNombre("LAPTOP");
	        producto1.setProductosActuales(20);

	        producto1.imprimir();
	        
	        producto1.vender(5);
	        producto1.imprimir(); 

	        
	        producto1.devolver(2);
	        producto1.imprimir(); 
	        
	        Item producto2 = new Item();
	        producto2.setNombre("CELULAR");
	        producto2.setProductosActuales(50);

	        producto2.vender(10);
	        producto2.devolver(3);
	        producto2.imprimir();

	}

}
