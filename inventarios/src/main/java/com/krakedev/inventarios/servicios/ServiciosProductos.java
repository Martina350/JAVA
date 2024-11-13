package com.krakedev.inventarios.servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProductosBDD;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.exceptions.KrakeDevException;

@Path ("productos")
public class ServiciosProductos {
	@Path("buscar/{sub}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("sub") String subcadena){
			ProductosBDD productBDD= new ProductosBDD();
			ArrayList<Producto> productos=null;
			try {
				productos = productBDD.buscar(subcadena);
				return Response.ok(productos).build();
			} catch (KrakeDevException e) {
				e.printStackTrace();
				return Response.serverError().build();
			} catch (SQLException e) {
				e.printStackTrace();
				return Response.serverError().build();
			}
		}

	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarProducto(Producto producto) {
		ProductosBDD productBDD= new ProductosBDD();
		System.out.println(">>>>> "+producto);
		try {
			productBDD.insertarProducto(producto);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
}
