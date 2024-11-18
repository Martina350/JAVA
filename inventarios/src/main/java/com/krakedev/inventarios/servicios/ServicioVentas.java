package com.krakedev.inventarios.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.CabeceraVentasBDD;
import com.krakedev.inventarios.entidades.CabeceraVenta;
import com.krakedev.inventarios.exceptions.KrakeDevException;

@Path("ventas")
public class ServicioVentas {
    @Path("guardar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarVentas(CabeceraVenta cabeceraVenta) {
        CabeceraVentasBDD ventasBDD = new CabeceraVentasBDD();
        try {
            ventasBDD.registrarVenta(cabeceraVenta);
            return Response.ok("Venta registrada exitosamente").build();
        } catch (KrakeDevException e) {
            return Response.serverError()
                           .entity("Error al registrar la venta: " + e.getMessage())
                           .build();
        }
    }
}
