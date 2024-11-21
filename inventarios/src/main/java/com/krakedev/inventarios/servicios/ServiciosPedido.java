package com.krakedev.inventarios.servicios;

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

import com.krakedev.inventarios.bdd.PedidosBDD;
import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.exceptions.KrakeDevException;



@Path ("pedidos")
public class ServiciosPedido {
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarPedido(Pedido pedido) {
		PedidosBDD pedidoBDD= new PedidosBDD();
		try {
			pedidoBDD.insertarPedido(pedido);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("recibir")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarPedido(Pedido pedido) {
		System.out.println("ACTUALIZANDO PEDIDO>>>>> "+pedido);
		 PedidosBDD pedidoBDD = new PedidosBDD();
		    try {
		        pedidoBDD.actualizarEstadoPedido(pedido);
		        return Response.ok().build();
		    } catch (KrakeDevException e) {
		        e.printStackTrace();
		        return Response.serverError().build();
		    }
	}

	@Path("buscar/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPedidosPorProveedor(@PathParam("id") String idProveedor) {
	    PedidosBDD pedBDD = new PedidosBDD();
	    try {
	        ArrayList<DetallePedido> pedidos = pedBDD.buscarPedidoPorProveedor(idProveedor);
	        return Response.ok(pedidos).build();
	    } catch (KrakeDevException e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }
	}

}
