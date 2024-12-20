package com.krakedev.pronosticos.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.pronosticos.bdd.PronosticoBDD;
import com.krakedev.pronosticos.entidades.Pronostico;
import com.krakedev.pronosticos.exceptions.KrakeDevException;

@Path ("pronostico")
public class ServicioPronostico {
	 @Path("usuario/{usuarioId}")
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response consultarPronosticosPorUsuario(@PathParam("usuarioId") int usuarioId) {
	        PronosticoBDD pronosticosBDD = new PronosticoBDD();
	        try {
	            ArrayList<Pronostico> pronosticos = pronosticosBDD.consultarPronosticosPorUsuario(usuarioId);
	            return Response.ok(pronosticos).build();
	        } catch (KrakeDevException e) {
	            e.printStackTrace();
	            return Response.serverError().build();
	        }
	    }

	 @Path("ingresar")
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response insertarPronostico(Pronostico pronostico) {
	        PronosticoBDD pronosticosBDD = new PronosticoBDD();
	        try {
	            pronosticosBDD.insertarPronostico(pronostico);
	            return Response.ok().build();
	        } catch (KrakeDevException e) {
	            e.printStackTrace();
	            return Response.serverError().build();
	        }
	    }
}
