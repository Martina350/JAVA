package com.krakedev.inventarios.servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.TipoDocumentoBDD;
import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.exceptions.KrakeDevException;


@Path("tiposdocumento")
public class ServiciosTipoDocumento {
	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerTipoDoc(){
		TipoDocumentoBDD tipDoc= new TipoDocumentoBDD();
		ArrayList<TipoDocumento> tipoDocs=null;
		try {
			tipoDocs=tipDoc.recuperarTiposDoc();
			return Response.ok(tipoDocs).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
