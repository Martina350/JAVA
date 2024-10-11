package com.cmc.evaluacion;

public class CalcularAmortizacion {
	public static double calcularCuota(Prestamo prestamo) {
        double co = prestamo.getMonto(); 
        double it = prestamo.getInteres() / 100 / 12; 
        int n = prestamo.getPlazo(); 
        double cuota = (co * it) / (1 - Math.pow((1 + it), -n));
        return cuota;
    }
}
