package com.krakedev.herencia;

public class Gato extends Animal{
	@Override
	public void dormir() {
		super.dormir();
		System.out.println("GATO ZZZ");
	}
	
	public void maullar() {
		System.out.println("MIAU");
	}
	
	public void maullar(String adjetivo) {
		System.out.println("GATO MAULLANDO: "+adjetivo);
	}
}
