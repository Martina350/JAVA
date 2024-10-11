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
	
	public ArrayList<Carta> barajar() {
		ArrayList<Carta> auxiliar = new ArrayList<>();
		int cartasSize = cartas.size();
		for (int i = 1; i <= 100; i++) {
			int valorRandom = Random.obtenerPosicion(cartasSize);
			if (cartas.get(valorRandom).getEstado().equals("N")) {
				auxiliar.add(cartas.get(valorRandom));
				cartas.get(valorRandom).setEstado("C");
			}
		}
		for (int i = 0; i < cartas.size(); i++) {
			if (cartas.get(i).getEstado().equals("N")) {
				auxiliar.add(cartas.get(i));
				cartas.get(i).setEstado("C");
			}
		}
		return auxiliar;

	}
	
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	
}
