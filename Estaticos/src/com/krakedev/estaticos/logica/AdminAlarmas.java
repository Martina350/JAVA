package com.krakedev.estaticos.logica;

import com.krakedev.estaticos.entidades.Alarma;
import java.util.ArrayList;

public class AdminAlarmas {
	private ArrayList <Alarma> alarmas;
	
	public AdminAlarmas() {
		this.alarmas = new ArrayList<>();
	}

	public void agregarAlarma(Alarma alarma) {
		this.alarmas.add(alarma);
	}

	public ArrayList<Alarma> getAlarmas() {
		return this.alarmas;
	}
}
