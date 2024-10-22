package com.krakedev.servicios;

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

import com.krakedev.entidades.Cliente;
import com.krakedev.execpciones.KrakeDevException;
import com.krakedev.persistencia.ClientesBdd;

@Path("customers")
public class ServicioClientes {
	@Path("m1")
	@GET
	public String saludar() {
		return "HELLO WORLD! REST WEB SERVICES";
	}
	
	@Path("buscar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscar() {
		Cliente cliente=new Cliente("1726312745","Martina",1);
		return cliente;
	}
	
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Cliente cliente) {
		System.out.println(">>>>> "+cliente);
		ClientesBdd cli= new ClientesBdd();
		try {
			cli.insertar(cliente);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Cliente cliente) {
		System.out.println("ACTUALIZANDO CLIENTE>>>>> "+cliente);
		 ClientesBdd cli = new ClientesBdd();
		    try {
		        cli.actualizar(cliente);
		        return Response.ok().build();
		    } catch (KrakeDevException e) {
		        e.printStackTrace();
		        return Response.serverError().build();
		    }
	}
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerClientes(){
		ClientesBdd cli= new ClientesBdd();
		ArrayList<Cliente> clientes=null;
		try {
			clientes = cli.recuperarTodos();
			return Response.ok(clientes).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarPorCedula/{cedulaParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCedula(@PathParam("cedulaParam") String cedula){
		ClientesBdd cli= new ClientesBdd();
		Cliente cliente=null;
		System.out.println("INGRESA: "+cedula);
		try {
			cliente = cli.buscarPK(cedula);
			return Response.ok(cliente).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarPorNumeroHijos/{numHijos}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorNumeroHijos(@PathParam("numHijos") int numHijos){
	    ClientesBdd cli = new ClientesBdd();
	    ArrayList<Cliente> clientes = null;
	    try {
	        clientes = cli.buscarPorNumeroHijos(numHijos);
	        return Response.ok(clientes).build();
	    } catch (KrakeDevException e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return Response.serverError().build();
	    }
	}
}

