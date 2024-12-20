package com.krakedev.pronosticos.entidades;

import java.util.ArrayList;

public class Pronostico {
	private int id;
    private int usuarioId;
    private int partidoId;
    private int golesLocal;
    private int golesVisitante;
    private ArrayList <Pronostico> pronosticos;
	public ArrayList<Pronostico> getPronosticos() {
		return pronosticos;
	}
	public void setPronosticos(ArrayList<Pronostico> pronosticos) {
		this.pronosticos = pronosticos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public int getPartidoId() {
		return partidoId;
	}
	public void setPartidoId(int partidoId) {
		this.partidoId = partidoId;
	}
	public int getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}
	public int getGolesVisitante() {
		return golesVisitante;
	}
	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	public Pronostico(int id, int usuarioId, int partidoId, int golesLocal, int golesVisitante) {
		super();
		this.id = id;
		this.usuarioId = usuarioId;
		this.partidoId = partidoId;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}
	public Pronostico() {
		super();
	}
	@Override
	public String toString() {
		return "Pronostico [id=" + id + ", usuarioId=" + usuarioId + ", partidoId=" + partidoId + ", golesLocal="
				+ golesLocal + ", golesVisitante=" + golesVisitante + "]";
	}
    
    
}
