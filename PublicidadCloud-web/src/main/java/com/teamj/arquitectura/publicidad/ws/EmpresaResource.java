/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.services.EmpresaServicio;
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
@Path("empresa")
@RequestScoped
public class EmpresaResource {

    @Context
    private UriInfo context;
    
    @EJB
    EmpresaServicio empresaServicio;

    /**
     * Creates a new instance of EmpresaResource
     */
    public EmpresaResource() {
    }

    /**
     * Retrieves representation of an instance of com.teamj.arquitectura.publicidad.ws.EmpresaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveEmpresas")
    public List<com.teamj.arquitectura.publicidad.model.Empresa> retrieveEmpresas() {
        //TODO return proper representation object
        return empresaServicio.retrieveEmp();        
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarEmpresa")
    public boolean registrarEmpresa(com.teamj.arquitectura.publicidad.model.Empresa content) {
        return empresaServicio.registrarEmp(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarEmpresa")
    public boolean editarEmpresa(com.teamj.arquitectura.publicidad.model.Empresa content) {
        return empresaServicio.editarEmp(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarEmpresa")
    public void eliminarEmpresa(com.teamj.arquitectura.publicidad.model.Empresa content) {
        empresaServicio.eliminarEmp(content.getRuc());
    }
}
