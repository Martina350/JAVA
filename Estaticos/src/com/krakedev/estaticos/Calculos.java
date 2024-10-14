package com.krakedev.estaticos;

public class Calculos {
	private final double IVA = 12;
	
	public double calcularIva(double monto) {
		return monto*IVA/100;
	}
	
	
}
