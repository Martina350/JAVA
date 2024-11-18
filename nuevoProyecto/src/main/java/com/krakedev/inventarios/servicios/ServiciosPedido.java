package com.krakedev.inventarios.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.PedidosBDD;
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

}
