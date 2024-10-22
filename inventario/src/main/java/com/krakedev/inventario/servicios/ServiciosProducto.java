package com.krakedev.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.krakedev.inventario.entidades.Producto;

@Path("productos")
public class ServiciosProducto {
	@Path("m1")
	@GET
	public String saludar() {
		return "HELLO WORLD! REST WEB SERVICES";
	}
	
	
	@Path("insertar")
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertarProducto(Producto producto) {
        System.out.println("Producto insertado: " + producto);
    }

	@Path("actualizar")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void actualizarProducto(Producto producto) {
        System.out.println("Producto actualizado: " + producto);
    }
    
    @Path("consultar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    public ArrayList<Producto> recuperarTodos() {
    	ArrayList<Producto> productos= new ArrayList<>();
        if (productos.isEmpty()) {
            productos.add(new Producto("P001", "Producto 1", null, 10.5, 100));
            productos.add(new Producto("P002", "Producto 2", null, 20.0, 50));
            productos.add(new Producto("P003", "Producto 3", null, 15.75, 75));
        }
        return productos;
    }
}
