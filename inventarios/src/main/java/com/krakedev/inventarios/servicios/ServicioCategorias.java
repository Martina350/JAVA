package com.krakedev.inventarios.servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.CategoriasBDD;
import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.exceptions.KrakeDevException;

@Path("categorias")
public class ServicioCategorias {
	@Path("crear")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearCategoria(Categoria categoria) {
        CategoriasBDD categoriasBDD = new CategoriasBDD();
        try {
            categoriasBDD.insertarCategoria(categoria);
            return Response.ok().build();
        } catch (KrakeDevException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarCategoria(Categoria categoria) {
	    CategoriasBDD catBDD = new CategoriasBDD();
	    try {
	        catBDD.actualizarCategoria(categoria);
	        return Response.ok().build();
	    } catch (KrakeDevException e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }
	}

	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperarCategorias() throws SQLException {
	    CategoriasBDD catBDD = new CategoriasBDD();
	    try {
	        ArrayList<Categoria> categorias = catBDD.obtenerCategorias();
	        return Response.ok(categorias).build();
	    } catch (KrakeDevException e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }
	}
}
