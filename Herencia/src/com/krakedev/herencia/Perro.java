package com.krakedev.herencia;

public class Perro extends Animal{
	
	public Perro() {
		System.out.println("EJECUTA CONSTRUCTOR PERRO");
	}
	
	
	public void ladrar() {
		System.out.println("PERRO LADRANDO");
	}
	@Override
	public void dormir() {
		super.dormir();
		System.out.println("PERRO DURMIENDO");
	}
}
