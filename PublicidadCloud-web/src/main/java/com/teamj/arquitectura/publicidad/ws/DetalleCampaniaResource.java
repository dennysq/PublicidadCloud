/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.services.DetalleCampaniaServicio;
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
@Path("detalleCampania")
@RequestScoped
public class DetalleCampaniaResource {

    @Context
    private UriInfo context;
    
    @EJB
    DetalleCampaniaServicio detalleCampaniaServicio;
    /**
     * Creates a new instance of DetalleCampaniaResource
     */
    public DetalleCampaniaResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveDetalleCampania")
    public List<com.teamj.arquitectura.publicidad.model.DetalleCampania> retrieveDetalleCampania() {
        //TODO return proper representation object
        return detalleCampaniaServicio.retrieveDetalleCamp();
    }
    
     @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarDetalleCampania")
    public boolean registrarDetalleCampania(com.teamj.arquitectura.publicidad.model.DetalleCampania content) {
        return detalleCampaniaServicio.registrarDetalleCamp(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarDetalleCampania")
    public boolean editarDetalleCampania(com.teamj.arquitectura.publicidad.model.DetalleCampania content) {
        return detalleCampaniaServicio.editarDetalleCamp(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarDetalleCampania")
    public void eliminarDetalleCampania(com.teamj.arquitectura.publicidad.model.DetalleCampania content) {
        detalleCampaniaServicio.eliminarDetalleCamp(content);
    }

}
