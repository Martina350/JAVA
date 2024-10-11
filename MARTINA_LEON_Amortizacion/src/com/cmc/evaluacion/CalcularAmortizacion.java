package com.cmc.evaluacion;

public class CalcularAmortizacion {
	public static double calcularCuota(Prestamo prestamo) {
        double co = prestamo.getMonto(); 
        double it = prestamo.getInteres() / 100 / 12; 
        int n = prestamo.getPlazo(); 
        double cuota = (co * it) / (1 - Math.pow((1 + it), -n));
        return cuota;
    }
	 public static void generarTabla(Prestamo prestamo) {
	        double cuotaValor = calcularCuota(prestamo);

	        for (int i = 0; i < prestamo.getPlazo(); i++) {
	            Cuota cuota = new Cuota(i + 1); 
	            cuota.setCuota(cuotaValor);
	            prestamo.getCuotas().add(cuota); 
	        }

	        prestamo.getCuotas().get(0).setInicio(prestamo.getMonto());

	        for (int i = 0; i < prestamo.getCuotas().size(); i++) {
	            Cuota siguienteCuota = (i < prestamo.getCuotas().size() - 1) ? prestamo.getCuotas().get(i + 1) : null;
	            calcularValoresCuota(prestamo.getInteres() / 100 / 12, prestamo.getCuotas().get(i), siguienteCuota);
	        }

	        Cuota ultimaCuota = prestamo.getCuotas().get(prestamo.getCuotas().size() - 1);
	        ultimaCuota.setSaldo(0); 
	        ultimaCuota.setCuota(ultimaCuota.getCuota() + ultimaCuota.getSaldo());
	 }

	 private static void calcularValoresCuota(double interesMensual, Cuota cuota, Cuota siguienteCuota) {
	        double interes = cuota.getInicio() * interesMensual;
	        double abonoCapital = cuota.getCuota() - interes;
	        double saldo = cuota.getInicio() - abonoCapital;

	        cuota.setInteres(interes);
	        cuota.setAbonoCapital(abonoCapital);
	        cuota.setSaldo(saldo);

	        if (siguienteCuota != null) {
	            siguienteCuota.setInicio(saldo); 
	        }
	 }

	 public static void mostrarTabla(Prestamo prestamo) {
	        System.out.printf("Numero | Cuota | Inicio | Interés | Abono Capital | Saldo%n");
	        for (int i = 0; i < prestamo.getCuotas().size(); i++) {
	        	Cuota cuota = prestamo.getCuotas().get(i); 
	            cuota.mostrarPrestamo();  
	        }
	 }
}
