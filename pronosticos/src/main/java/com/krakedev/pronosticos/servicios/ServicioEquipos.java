package com.krakedev.pronosticos.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.pronosticos.bdd.EquipoBDD;
import com.krakedev.pronosticos.entidades.Equipo;
import com.krakedev.pronosticos.exceptions.KrakeDevException;

@Path ("equipos")
public class ServicioEquipos {
	@Path("ingresar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarEquipo(Equipo equipo) {
        EquipoBDD equipoBDD = new EquipoBDD();
        try {
            equipoBDD.insertarEquipo(equipo);
            return Response.ok().build();
        } catch (KrakeDevException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
