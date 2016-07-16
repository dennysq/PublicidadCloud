/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.services.ElementoServicio;
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
@Path("elemento")
@RequestScoped
public class ElementoResource {

    @Context
    private UriInfo context;
    
    @EJB
    ElementoServicio elementoServicio;

    /**
     * Creates a new instance of ElementoResource
     */
    public ElementoResource() {
    }

    /**
     * Retrieves representation of an instance of com.teamj.arquitectura.publicidad.ws.ElementoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveElementos")
    public List<com.teamj.arquitectura.publicidad.model.Elemento> retrieveElementos() {
        //TODO return proper representation object
        return elementoServicio.retrieveElem();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarElemento")
    public boolean registrarElemento(com.teamj.arquitectura.publicidad.model.Elemento content) {
        return elementoServicio.registrarElem(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarElemento")
    public boolean editarElemento(com.teamj.arquitectura.publicidad.model.Elemento content) {
        return elementoServicio.editarElem(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarElemento")
    public void eliminarElemento(com.teamj.arquitectura.publicidad.model.Elemento content) {
        elementoServicio.eliminarElem(content.getId());
    }
}
