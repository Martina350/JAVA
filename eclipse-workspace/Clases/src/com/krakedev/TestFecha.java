package com.krakedev;

public class TestFecha {

	public static void main(String[] args) {
		Fecha fecha1=new Fecha(2000,12,12);
		Fecha fecha2=new Fecha(2006,11,06);
		
		System.out.println(fecha2.getAnio());
		System.out.println(fecha2.getMes());
		System.out.println(fecha2.getDia());
		System.out.println("--------");
		
		fecha1.setAnio(2000);
		fecha1.setMes(12);
		fecha1.setDia(12);
		
		System.out.println(fecha1.getAnio());
		System.out.println(fecha1.getMes());
		System.out.println(fecha1.getDia());
	}

}
