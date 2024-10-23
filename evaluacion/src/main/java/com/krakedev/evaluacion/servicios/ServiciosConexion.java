package com.krakedev.evaluacion.servicios;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

@Path("bases")
public class ServiciosConexion {
	
	@Path("probarConexion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void probarConn() {
        Connection con;
		try {
			con = ConexionBDD.obtenerConexion();
			if (con != null) {
	            System.out.println("Conexión exitosa");
	        } else {
	            System.out.println("Error al obtener Conexión");
	        }
		} catch (KrakeException e) {
			e.printStackTrace();
		}
        
    }
}
