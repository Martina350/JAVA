package com.entidades;

import java.util.ArrayList;

import com.servicios.Juego;

public class Jugadores {
	private ArrayList<String> jugadores;
	private Juego ganador;

    public Jugadores() {
        this.jugadores = new ArrayList<String>();
    }
    public ArrayList<String> getJugadores() {
        return this.jugadores;
    }
    public void setJugadores(ArrayList<String> jugadores) {
        this.jugadores = jugadores;
    }
    public void agregarJugador(String nombre) {
        this.jugadores.add(nombre);
    }
    
    public void jugar() {
		
		Juego jugador=new Juego(jugadores);
		jugador.entregarCartas(5);
		
		for(int i=0;i<jugadores.size();i++) {
			jugadores.get(i);
			System.out.println("Total del jugador "+jugadores.get(i)+": "+jugador);
		}

		ganador.determinarGanador();
		System.out.println("El ganador es: "+ganador);
	} 
 
}