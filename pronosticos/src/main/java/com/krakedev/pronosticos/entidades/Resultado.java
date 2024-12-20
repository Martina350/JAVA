package com.krakedev.pronosticos.entidades;

public class Resultado {
	private int id;
    private int partidoId;
    private int golesLocal;
    private int golesVisitante;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Resultado(int id, int partidoId, int golesLocal, int golesVisitante) {
		super();
		this.id = id;
		this.partidoId = partidoId;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}
	public Resultado() {
		super();
	}
	@Override
	public String toString() {
		return "Resultado [id=" + id + ", partidoId=" + partidoId + ", golesLocal=" + golesLocal + ", golesVisitante="
				+ golesVisitante + "]";
	}
    
    
}
