package com.entidades;

import java.util.ArrayList;

public class Numero {
	private String numeroCarta;
	private int valor;
	
	public void mostrarInfo() {
		ArrayList<Numero> numeros= new ArrayList<Numero>();
		Numero numero;
		for(int i= 0; i<numeros.size(); i++) {
			numero=numeros.get(i);
			System.out.println(numero.numeroCarta+ "-"+numero.valor);
		}
	}
	
	public Numero(String numeroCarta, int valor) {
		this.numeroCarta = numeroCarta;
		this.valor = valor;
	}
	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
