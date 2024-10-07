package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	ArrayList<Celda> celdas;
	private double saldo;
	
	public MaquinaDulces() {
        celdas = new ArrayList<>();
    }
	
	public void agregarCelda(Celda codigo) {
		celdas.add(codigo);
	}
	
	public void mostrarConfiguracion() {
		Celda elementoCelda;
	    for(int i = 0; i < celdas.size(); i++) {
	        elementoCelda = celdas.get(i); 
	        System.out.println("Celda" + (i + 1) + ":" + elementoCelda.getCodigo());
	    }
	}
	
	public Celda buscarCelda(String codigo) {
	    Celda celdaEncontrada = null; 
	    Celda elementoCelda = null;   
	    for(int i = 0; i < celdas.size(); i++) {
	        elementoCelda = celdas.get(i); 
	        if(codigo.equals(elementoCelda.getCodigo())) { 
	            celdaEncontrada = elementoCelda; 
	        }
	    }
	    return celdaEncontrada; 
	}
	
	public void cargarProducto(Producto producto, String codigoCelda, int cantidad) {
	   Celda celdaRecuperada = buscarCelda(codigoCelda);
	     if (celdaRecuperada != null) {
	         celdaRecuperada.ingresarProducto(producto, cantidad);  
	     } else {
	            System.out.println("Celda no encontrada.");
	     }
	}
	
	public void mostrarProductos() {
	    for (Celda celda : celdas) {
	        Producto producto = celda.getProducto();  
	        System.out.print("Celda:" + celda.getCodigo() + " Stock:" + celda.getStock());

	        if (producto != null) {
	            System.out.println(" Producto:" + producto.getNombre() + " Precio:" + producto.getPrecio());
	        } else {
	            System.out.println(" Sin Producto asignado");
	        }
	    }
	}
	
}
