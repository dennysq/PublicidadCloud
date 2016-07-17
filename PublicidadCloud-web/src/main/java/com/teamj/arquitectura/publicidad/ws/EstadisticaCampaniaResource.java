/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.services.EstadisticaCampaniaServicio;
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
@Path("estadisticaCampania")
@RequestScoped
public class EstadisticaCampaniaResource {

    @Context
    private UriInfo context;
    
     @EJB
     EstadisticaCampaniaServicio estadisticaCampaniaServicio;
    /**
     * Creates a new instance of EstadisticaCampaniaResource
     */
    public EstadisticaCampaniaResource() {
    }

    /**
     * Retrieves representation of an instance of com.teamj.arquitectura.publicidad.ws.EstadisticaCampaniaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveEstadisticaCampania")
    public List<com.teamj.arquitectura.publicidad.model.EstadisticaCampania> retrieveEstadisticaCampania() {
        //TODO return proper representation object
        return estadisticaCampaniaServicio.retrieveEstadisticaServ();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarEstadisticaCampania")
    public boolean registrarEstadisticaCampania(com.teamj.arquitectura.publicidad.model.EstadisticaCampania content) {
        return estadisticaCampaniaServicio.registrarEstadisticaServ(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarEstadisticaCampania")
    public boolean editarEstadisticaCampania(com.teamj.arquitectura.publicidad.model.EstadisticaCampania content) {
        return estadisticaCampaniaServicio.editarEstadisticaServ(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarEstadisticaCampania")
    public void eliminarEstadisticaCampania(com.teamj.arquitectura.publicidad.model.EstadisticaCampania content) {
        estadisticaCampaniaServicio.eliminarEstadisticaServ(content.getCampania().getSec());
    }
}
