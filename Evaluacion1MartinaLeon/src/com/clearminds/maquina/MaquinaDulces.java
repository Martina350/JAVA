package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;

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
}
