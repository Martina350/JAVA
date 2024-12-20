package com.krakedev.pronosticos.entidades;

public class Partido {
	private int id;
	private int equipoLocal;
	private int equipoVisitante;
	private String fecha;
	private String hora;
	private String estadio;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(int equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public int getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(int equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public Partido(int id, int equipoLocal, int equipoVisitante, String fecha, String hora, String estadio) {
		super();
		this.id = id;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fecha = fecha;
		this.hora = hora;
		this.estadio = estadio;
	}
	public Partido() {
		super();
	}
	@Override
	public String toString() {
		return "Partido [id=" + id + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante
				+ ", fecha=" + fecha + ", hora=" + hora + ", estadio=" + estadio + "]";
	}
	
	
}
