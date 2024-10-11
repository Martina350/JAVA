package com.servicios;

import java.util.ArrayList;
import com.entidades.Carta;
import com.entidades.Naipe;

public class Juego {
	private Naipe naipe=new Naipe();
	private ArrayList<ArrayList<Carta>> cartasJugador=new ArrayList<>();

	
	
	public Juego(ArrayList<String> nombresJugadores) {
		cartasJugador = new ArrayList<>();
	        for (int i = 0; i < nombresJugadores.size(); i++) {
	            cartasJugador.add(new ArrayList<Carta>()); 
	        }
	}
	
	public void entregarCartas(int cartasPorJugador) {
	    ArrayList<Carta> cartaBarajada = naipe.barajar(); 
	    int totalJugadores = cartasJugador.size();
	    int indexCarta = 0;
	    for (int i = 0; i < cartasPorJugador; i++) {
	        for (int j = 0; j < totalJugadores; j++) {

	            if (indexCarta < cartaBarajada.size()) {
	                cartasJugador.get(j).add(cartaBarajada.get(indexCarta));
	                indexCarta++;
	            } 
	        }
	    }
	}
	public int devolverTotal(int idJugador) {
		ArrayList<Carta> cartaJugador = cartasJugador.get(idJugador);
		int total = 0;
		for (int i = 0; i < cartaJugador.size(); i++) {
			total += cartaJugador.get(i).getNumero().getValor();
		}
		return total;
	}
	
	public String determinarGanador() {
        int idGanador=0;
        int sumaGanador=0;
        
        for (int i = 1; i < cartasJugador.size(); i++) {
			int sumaJugador = devolverTotal(i);
			if (sumaJugador >= sumaGanador) {
				idGanador = i;
				sumaGanador = sumaJugador;
			}
		}
 
        return idGanador+1 +"";
	}
}
