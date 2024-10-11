package com.entidades;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Numero> numerosPosibles = new ArrayList<>();
	private ArrayList<Carta> cartas = new ArrayList<>();
	private Palos palos = new Palos();
	
	public Naipe() {
		for (int i = 2; i <= 10; i++) {
            numerosPosibles.add(new Numero(String.valueOf(i), i));
        }
        numerosPosibles.add(new Numero("J", 10));
        numerosPosibles.add(new Numero("Q", 10));
        numerosPosibles.add(new Numero("K", 10));
        String[] palosArray = {palos.getCorazonRojo(), palos.getCorazonNegro(), palos.getDiamante(), palos.getTrebol()};
        for (int j = 0; j < numerosPosibles.size(); j++) {
            for (int k = 0; k < palosArray.length; k++) {
                String palo = palosArray[k];  
                Numero num = numerosPosibles.get(j);  
                Carta carta = new Carta(num, palo);
                cartas.add(carta);
            }
        }
	}
	
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	
}
