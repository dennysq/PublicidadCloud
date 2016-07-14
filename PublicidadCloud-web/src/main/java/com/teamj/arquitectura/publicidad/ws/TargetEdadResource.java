/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.services.TargetEdadServicio;
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
@Path("targetEdad")
@RequestScoped
public class TargetEdadResource {

    @Context
    private UriInfo context;
    
    @EJB
    TargetEdadServicio targetEdadServicio;

    /**
     * Creates a new instance of TargetEdadResource
     */
    public TargetEdadResource() {
    }

    /**
     * Retrieves representation of an instance of com.teamj.arquitectura.publicidad.ws.TargetEdadResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveTargetEdad")
    public List<com.teamj.arquitectura.publicidad.model.TargetEdad> retrieveTargetEdad() {
        //TODO return proper representation object
        return targetEdadServicio.retrieveTargetE();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarTargetEdad")
    public void registrarTargetEdad(com.teamj.arquitectura.publicidad.model.TargetEdad content) {
        targetEdadServicio.registrarTargetE(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarTargetEdad")
    public boolean editarTargetEdad(com.teamj.arquitectura.publicidad.model.TargetEdad content) {
        return targetEdadServicio.editarTargetE(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarTargetEdad")
    public void eliminarTargetEdad(com.teamj.arquitectura.publicidad.model.TargetEdad content) {
        targetEdadServicio.eliminarTargetE(content.getId());
    }
}
