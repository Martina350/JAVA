package com.krakedev.test;

import com.krakedev.Auto;

public class TestAuto {

	public static void main(String[] args) {
		Auto auto1=new Auto("Chevrolet",2017,138.25);
		Auto auto2=new Auto("KIA",2025,289.78);
		Auto auto3=new Auto("Renault",2012,188.60);
		
		System.out.println("marca:"+auto3.getMarca());
		System.out.println("anio:"+auto3.getAnio());
		System.out.println("precio:"+auto3.getPrecio());

		auto1.setMarca("Chevrolet");
		auto1.setAnio(2017);
		auto1.setPrecio(138.25);

		System.out.println("------");
		System.out.println("marca:"+auto1.getMarca());
		System.out.println("anio:"+auto1.getAnio());
		System.out.println("precio:"+auto1.getPrecio());

		auto2.setMarca("KIA");
		auto2.setAnio(2025);
		auto2.setPrecio(289.78);

		System.out.println("------");
		System.out.println("marca:"+auto2.getMarca());
		System.out.println("anio:"+auto2.getAnio());
		System.out.println("precio:"+auto2.getPrecio());
	}

}
