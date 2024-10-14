package com.krakedev.estaticos.ejercicio.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
	public static String formatearHora(int numero) {
		String valor= numero +"";
		if(valor.length()==1) {
			valor = "0" + valor;
		}
		return valor;
	}
	
	public static String formatearDia(int dia) {
		ArrayList<String> diasSemana = new ArrayList<>(Arrays.asList(
			"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"
		));
		if (dia >= 0 && dia < diasSemana.size()) {
			return diasSemana.get(dia);
		} else {
			return "Día inválido"; 
		}
	}
	
    public static String formatearMinuto(int numero) {
        String valor = numero + "";
        if (valor.length() == 1) {
            valor = "0" + valor;
        }
        return valor;
    }
}
