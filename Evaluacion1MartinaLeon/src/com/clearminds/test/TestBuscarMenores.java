package com.clearminds.test;

import com.clearminds.maquina.MaquinaDulces;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;


public class TestBuscarMenores {

	public static void main(String[] args) {
        MaquinaDulces maquina = new MaquinaDulces();
        maquina.agregarCelda(new Celda("A1"));
        maquina.agregarCelda(new Celda("A2"));
        maquina.agregarCelda(new Celda("B1"));
        maquina.agregarCelda(new Celda("B2"));
        maquina.agregarCelda(new Celda("C1"));
        maquina.agregarCelda(new Celda("C2"));

        Producto producto1 = new Producto("Papitas", 0.85, "KE34");
        maquina.cargarProducto(producto1, "B1", 4);
        Producto producto2 = new Producto("Doritos", 0.70, "D456");
        maquina.cargarProducto(producto2, "A1", 6);
        Producto producto3 = new Producto("Jet", 0.25, "J789");
        maquina.cargarProducto(producto3, "C1", 5);
        Producto producto4 = new Producto("DeTodito", 0.60, "DT12");
        maquina.cargarProducto(producto4, "A2", 3);        

        ArrayList<Producto> menores= maquina.buscarMenores(1.0);
        
        System.out.println("Productos Menores: " + menores.size());
        System.out.println("Nombre: "+producto1.getNombre()+" "+"Precio: "+producto1.getPrecio());
        System.out.println("Nombre: "+producto2.getNombre()+" "+"Precio: "+producto2.getPrecio());
        System.out.println("Nombre: "+producto3.getNombre()+" "+"Precio: "+producto3.getPrecio());
        System.out.println("Nombre: "+producto4.getNombre()+" "+"Precio: "+producto4.getPrecio());
        

	}
}