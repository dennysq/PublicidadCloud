/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.model.Usuario;
import com.teamj.arquitectura.publicidad.services.UsuarioServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Andres
 */
@Path("usuario")
@RequestScoped
public class UsuarioResource {

    @Context
    private UriInfo context;
    
    @EJB
    UsuarioServicio usuarioServicio;
    

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of com.teamj.arquitectura.publicidad.ws.UsuarioResource
     * @return an instance of com.teamj.arquitectura.publicidad.model.Usuario
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveUsers")
    public List<com.teamj.arquitectura.publicidad.model.Usuario> retrieveUsers() {
        //TODO return proper representation object
        return usuarioServicio.retrieveUsers();        
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarUsuario")
    public void registrarUsuario(com.teamj.arquitectura.publicidad.model.Usuario content) {
        usuarioServicio.registrarUsu(content);
    }  
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarUsuario")
    public boolean editarUsuario(com.teamj.arquitectura.publicidad.model.Usuario content) {
        return usuarioServicio.editarUsu(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarUsuario")
    public void eliminarUsuario(com.teamj.arquitectura.publicidad.model.Usuario content) {
        usuarioServicio.eliminarUsu(content.getId());
    }
}
