/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.services.CampaniaServicio;
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
@Path("campania")
@RequestScoped
public class CampaniaResource {

    @Context
    private UriInfo context;
    
    @EJB
    CampaniaServicio campaniaServicio;

    /**
     * Creates a new instance of CampaniaResource
     */
    public CampaniaResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveCampanias")
    public List<com.teamj.arquitectura.publicidad.model.Campania> retrieveCampanias() {
        //TODO return proper representation object
        return campaniaServicio.retrieveCampania();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarCampania")
    public void registrarCampania(com.teamj.arquitectura.publicidad.model.Campania content) {
        campaniaServicio.registrarCampania(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarCampania")
    public boolean editarCampania(com.teamj.arquitectura.publicidad.model.Campania content) {
        return campaniaServicio.editarCampania(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarCampania")
    public void eliminarCampania(com.teamj.arquitectura.publicidad.model.Campania content) {
        campaniaServicio.eliminarCampania(content.getSec());
    }
}
