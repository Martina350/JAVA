package com.krakedev.inventario.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.krakedev.inventario.entidades.Categoria;

@Path("categorias")
public class ServiciosCategoria {
    @Path("insertar")
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertarCategoria(Categoria categoria) {
        System.out.println("Categoría insertada: " + categoria);
    }
}
