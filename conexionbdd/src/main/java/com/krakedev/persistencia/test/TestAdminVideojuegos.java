package com.krakedev.persistencia.test;


import java.util.Date;

import com.krakedev.persistencia.entidades.Plataformas;
import com.krakedev.persistencia.entidades.Videojuegos;
import com.krakedev.persistencia.servicios.AdminVideojuegos;
import com.krakedev.persistencia.utils.Convertidor;

//System.out.println solo en los Test
public class TestAdminVideojuegos {

	public static void main(String[] args) {
		Plataformas pl= new Plataformas(12,"Xbox",5);
		Videojuegos v= new Videojuegos(14,"Roblox","Juego Online",9,pl);
		
		try {
			Date fechaPubli=Convertidor.convertirFecha("2009/05/14");
			v.setFechaPublicacion(fechaPubli);
			AdminVideojuegos.insertar(v);
		}catch (Exception e){
			System.out.println("ERROR EN EL SISTEMA: "+e.getMessage());
		}
		
		
	}

}
