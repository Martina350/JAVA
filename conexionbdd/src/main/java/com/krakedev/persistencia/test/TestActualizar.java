package com.krakedev.persistencia.test;

import com.krakedev.persistencia.entidades.Plataformas;
import com.krakedev.persistencia.entidades.Videojuegos;
import com.krakedev.persistencia.servicios.AdminVideojuegos;
import com.krakedev.persistencia.utils.Convertidor;

public class TestActualizar {

	public static void main(String[] args) {
		Plataformas pl = new Plataformas(12, "Nintendo", 3);
        Videojuegos v = new Videojuegos(14, "Mario Kart", "Juego de Carreras", 10, pl);

        try {
            v.setFechaPublicacion(Convertidor.convertirFecha("2011/11/18"));
            AdminVideojuegos.actualizar(v);
            System.out.println("VIDEOJUEGO ACTUALIZADO EXITOSAMENTE");
        } catch (Exception e) {
            System.out.println("ERROR EN EL SISTEMA: " + e.getMessage());
        }

	}

}
