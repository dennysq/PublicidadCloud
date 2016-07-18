/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.services.HistorialCampaniaServicio;
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
@Path("historialCampania")
@RequestScoped
public class HistorialCampaniaResource {

    @Context
    private UriInfo context;
    
     @EJB
     HistorialCampaniaServicio historialCampaniaServicio;

    /**
     * Creates a new instance of HistorialCampaniaResource
     */
    public HistorialCampaniaResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveHistorialCampania")
    public List<com.teamj.arquitectura.publicidad.model.HistorialCampania> retrieveHistorialCampania() {
        //TODO return proper representation object
        return historialCampaniaServicio.retrieveHistorialCamp();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarHistorialCampania")
    public boolean registrarHistorialCampania(com.teamj.arquitectura.publicidad.model.HistorialCampania content) {
        return historialCampaniaServicio.registrarHistorialCamp(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarHistorialCampania")
    public boolean editarHistorialCampania(com.teamj.arquitectura.publicidad.model.HistorialCampania content) {
        return historialCampaniaServicio.editarHistorialCamp(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarHistorialCampania")
    public void eliminarHistorialCampania(com.teamj.arquitectura.publicidad.model.HistorialCampania content) {
        historialCampaniaServicio.eliminarHistorialCamp(content.getId());
    }
   
}
