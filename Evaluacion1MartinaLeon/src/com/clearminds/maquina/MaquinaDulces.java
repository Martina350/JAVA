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
	    System.out.println("Saldo: " + saldo);
	}
	
	public Producto buscarProductoEnCelda(String codigoCelda) {
	    Celda celda = buscarCelda(codigoCelda);
	    if (celda != null) {
	        return celda.getProducto();
	    }
	    return null;
	}
	
	public double consultarPrecio(String codigoCelda) {
	    Celda celda = buscarCelda(codigoCelda); 
	    if (celda != null && celda.getProducto() != null) { 
	        return celda.getProducto().getPrecio(); 
	    } else {
	        System.out.println("Celda o producto no encontrado.");
	        return 0.0; 
	    }
	}
	
	public Celda buscarCeldaProducto(String codigoProducto) {
	    Celda celdaEncontrada = null; 
	    Celda elementoCelda = null;   
	    for (int i = 0; i < celdas.size(); i++) {
	        elementoCelda = celdas.get(i); 
	        Producto producto = elementoCelda.getProducto();  
	        if (producto != null && codigoProducto.equals(producto.getCodigo())) { 
	            celdaEncontrada = elementoCelda; 
	        }
	    }
	    return celdaEncontrada;
	}
	
	public void incrementarProductos(String codigoProducto, int cantidad) {
	    Celda celdaEncontrada = buscarCeldaProducto(codigoProducto);

	    if (celdaEncontrada != null) {
	        int stockActual = celdaEncontrada.getStock();
	        celdaEncontrada.setStock(stockActual + cantidad); 
	        Producto producto = celdaEncontrada.getProducto(); 
	        if (producto != null) {
	            System.out.println("Celda:" + celdaEncontrada.getCodigo() + 
	                               " Stock:" + celdaEncontrada.getStock() +
	                               " Producto:" + producto.getNombre() + 
	                               " Precio:" + producto.getPrecio());
	        } else {
	            System.out.println("Celda:" + celdaEncontrada.getCodigo() + 
	                               " Stock:" + celdaEncontrada.getStock() + 
	                               " Sin Producto asignado");
	        }
	    }
	}
	
	 public void vender(String codigoCelda) {
	        Celda celda = buscarCelda(codigoCelda);
	        if (celda != null && celda.getStock() > 0) {
	            Producto producto = celda.getProducto();
	            if (producto != null) {
	                celda.setStock(celda.getStock() - 1);
	                saldo += producto.getPrecio();
	            }
	        }
	 }
	 
	
}