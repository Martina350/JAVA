package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;
	
	public void configurarMaquina(String codigo1, String codigo2, String codigo3, String codigo4) {
		Celda valores1 = new Celda(codigo1);
		celda1 = valores1;
		Celda valores2 = new Celda(codigo2);
		celda2 = valores2;
		Celda valores3 = new Celda(codigo3);
		celda3 = valores3;
		Celda valores4 = new Celda(codigo4);
		celda4 = valores4;
	}
	
	public void mostrarConfiguracion() {
		System.out.println("CELDA 1: "+celda1.getCodigo());
		System.out.println("CELDA 2: "+celda2.getCodigo());
		System.out.println("CELDA 3: "+celda3.getCodigo());
		System.out.println("CELDA 4: "+celda4.getCodigo());
	}
	
	public Celda buscarCelda(String codigo) {
		if(codigo == celda1.getCodigo()) {
			return celda1;
		}else if (codigo == celda2.getCodigo()) {
			return celda2;
		}else if (codigo == celda3.getCodigo()) {
			return celda3;
		}else if (codigo == celda4.getCodigo()) {
			return celda4;
		}else {
			return null;
		}
	}
	
	public void cargarProducto(Producto nombre, String codigo, int stock) {
		Celda celdaRecuperada = buscarCelda(codigo);
		celdaRecuperada.ingresarProducto(nombre, stock);
	}
	
	public void mostrarProductos() {
		System.out.println("CODIGO DE CELDA: "+celda1.getCodigo());
		System.out.println("PRODUCTO: "+celda1.getProducto());
		System.out.println("PRECIO: "+celda1.getProducto().getPrecio());
		System.out.println("STOCK: "+celda1.getStock());
		System.out.println("******************************************");
		System.out.println("CODIGO DE CELDA: "+celda2.getCodigo());
		System.out.println("PRODUCTO: "+celda2.getProducto());
		System.out.println("PRECIO: "+celda2.getProducto().getPrecio());
		System.out.println("STOCK: "+celda2.getStock());
		System.out.println("******************************************");
		System.out.println("CODIGO DE CELDA: "+celda3.getCodigo());
		System.out.println("PRODUCTO: "+celda3.getProducto());
		System.out.println("PRECIO: "+celda3.getProducto().getPrecio());
		System.out.println("STOCK: "+celda3.getStock());
		System.out.println("******************************************");
		System.out.println("CODIGO DE CELDA: "+celda4.getCodigo());
		System.out.println("PRODUCTO: "+celda4.getProducto());
		System.out.println("PRECIO: "+celda4.getProducto().getPrecio());
		System.out.println("STOCK: "+celda4.getStock());
		System.out.println("******************************************");
	}
	
	public Producto buscarProductoEnCelda(String cod) {
		if (cod == celda1.getCodigo()) {
			return celda1.getProducto();
		} else if (cod == celda2.getCodigo()) {
			return celda2.getProducto();
		} else if (cod == celda3.getCodigo()) {
			return celda3.getProducto();
		} else if (cod == celda3.getCodigo()) {
			return celda3.getProducto();
		} else {
			return null;
		}
	}
	
	public double consultarPrecio(String codg) {
		if (codg == celda1.getCodigo()) {
			return celda1.getProducto().getPrecio();
		} else if (codg == celda2.getCodigo()) {
			return celda2.getProducto().getPrecio();
		} else if (codg == celda3.getCodigo()) {
			return celda3.getProducto().getPrecio();
		} else if (codg == celda4.getCodigo()) {
			return celda4.getProducto().getPrecio();
		} else {
			return 0.0;
		}
	}
	
	public Celda buscarCeldaProducto(String codigo) {
		if(celda1.getProducto().getCodigo() != null) {
			return celda1;
		}else if (celda2.getProducto().getCodigo() != null) {
			return celda2;
		}else if (celda3.getProducto().getCodigo() != null) {
			return celda3;
		}else if (celda4.getProducto().getCodigo() != null) {
			return celda4;
		}else {
			return null;
		}
	}
	
	public void incrementarProductos(String codigo, int stock) {
	    Celda celdaEncontrada = buscarCeldaProducto(codigo);
	    int suma;
		suma = celdaEncontrada.getStock() + stock;
		celdaEncontrada.setStock(suma);
	}
	
	public void vender(String codigo) {
		Celda vender=buscarCelda(codigo);
		vender.setStock(vender.getStock()-1);
		saldo +=vender.getProducto().getPrecio();
	}
	
	public double venderConCambio(String codigo, double pago) {
		Celda venderCambio;
		venderCambio=buscarCelda(codigo);
		venderCambio.setStock(venderCambio.getStock()-1);
		double resultado;
		resultado=pago-venderCambio.getProducto().getPrecio();
		saldo+=venderCambio.getProducto().getPrecio();
		return resultado;
		
	}
	
	public Celda getCelda1() {
		return celda1;
	}
	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}
	public Celda getCelda2() {
		return celda2;
	}
	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}
	public Celda getCelda3() {
		return celda3;
	}
	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}
	public Celda getCelda4() {
		return celda4;
	}
	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
