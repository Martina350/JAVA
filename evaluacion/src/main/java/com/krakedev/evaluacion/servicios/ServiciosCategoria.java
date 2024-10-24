package com.krakedev.evaluacion.servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.persistencia.HistorialBDD;

@Path("funciones")
public class ServiciosCategoria {
	 	
		@Path("probarInsertar")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
	    public Response insertar(Categoria categoria) {
	        System.out.println("CATEGORIA INSERTADA: "+categoria);
			HistorialBDD his = new HistorialBDD();
	        try {
	            his.insertar(categoria);
	            return Response.ok().build();
	        } catch (KrakeException e) {
	            return Response.serverError().build();
	        }
	    }

		@Path("probarActualizar")
		@PUT
		
		public Response actualizar(Categoria categoria) {
			 System.out.println("CATEGORIA ACTUALIZADA: "+categoria);
			HistorialBDD his = new HistorialBDD();
		    try {
		        his.actualizar(categoria);
		        return Response.ok().build();
		    } catch (KrakeException e) {
		        return Response.serverError().build();
		    }
		}

		@Path("probarBuscar/{paramId}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response buscarPorId(@PathParam("paramId") String id) {
		    HistorialBDD his = new HistorialBDD();
		    Categoria categoria = null;
		    System.out.println("ENCUENTRA ID DE LA CATEGORIA: "+id);
		    try {
		        categoria = his.buscarPorId(id);
		        return Response.ok(categoria).build();
		    } catch (KrakeException | SQLException e) {
		        return Response.serverError().build();
		    }
		}

		@Path("probarRecuperar")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response probarRecuperar() {
		    HistorialBDD his = new HistorialBDD();
		    ArrayList<Categoria> categorias = null;
		    try {
		        categorias = his.recuperarTodos();
		        return Response.ok(categorias).build();
		    } catch (KrakeException e) {
		        return Response.serverError().build();
		    }
		}

}
