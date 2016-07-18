/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.services.DetalleFacturaSerivicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Klever
 */
@Path("detalleFactura")
@RequestScoped
public class DetalleFacturaResource {

    @Context
    private UriInfo context;
    
    @EJB
    DetalleFacturaSerivicio detalleFacturaSerivicio;

    /**
     * Creates a new instance of DetalleFacturaResource
     */
    public DetalleFacturaResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveDetalleFacturas")
    public List<com.teamj.arquitectura.publicidad.model.DetalleFactura> retrieveDetalleFacturas() {
        //TODO return proper representation object
        return detalleFacturaSerivicio.retrieveDetalleFactura();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarDetalleFactura")
    public boolean registrarDetalleFactura(com.teamj.arquitectura.publicidad.model.DetalleFactura content) {
        return detalleFacturaSerivicio.registrarDetalleFactura(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarDetalleFactura")
    public boolean editarDetalleFactura(com.teamj.arquitectura.publicidad.model.DetalleFactura content) {
        return detalleFacturaSerivicio.registrarDetalleFactura(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarDetalleFactura")
    public void eliminarDetalleFactura(com.teamj.arquitectura.publicidad.model.DetalleFactura content) {
        detalleFacturaSerivicio.eliminarDetalleFactura(content.getFacturaEmpresa().getId());
    }
}
