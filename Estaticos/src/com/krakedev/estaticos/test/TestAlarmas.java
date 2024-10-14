package com.krakedev.estaticos.test;

import java.util.ArrayList;
import com.krakedev.estaticos.entidades.Alarma;
import com.krakedev.estaticos.logica.AdminAlarmas;
import com.krakedev.estaticos.ejercicio.utils.DiaSemana;

public class TestAlarmas {

	public static void main(String[] args) {
		AdminAlarmas admin = new AdminAlarmas();
		admin.agregarAlarma(new Alarma(DiaSemana.LUNES, 5, 45));
		admin.agregarAlarma(new Alarma(DiaSemana.MARTES, 6, 30));
		admin.agregarAlarma(new Alarma(DiaSemana.MIERCOLES, 7, 15));
		admin.agregarAlarma(new Alarma(DiaSemana.JUEVES, 8, 0));
		admin.agregarAlarma(new Alarma(DiaSemana.VIERNES, 9, 45));
		admin.agregarAlarma(new Alarma(DiaSemana.SABADO, 7, 10));
		admin.agregarAlarma(new Alarma(DiaSemana.DOMINGO, 1, 5));
		ArrayList<Alarma> alarmasActuales = admin.getAlarmas();
		for (int i = 0; i < alarmasActuales.size(); i++) {
            Alarma alarma = alarmasActuales.get(i); 
            System.out.println(alarma); 
        }
		
	}

}
