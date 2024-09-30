package com.cmc.repaso.entidades;

public class Validacion {
	public boolean validarMonto(double monto) {
		if(monto>0) {
			System.out.println("MONTO MAYOR QUE 0");
			return true;
		}else {
			System.out.println("MONTO INCORRECTO");
			return false;
		}
	}
}
