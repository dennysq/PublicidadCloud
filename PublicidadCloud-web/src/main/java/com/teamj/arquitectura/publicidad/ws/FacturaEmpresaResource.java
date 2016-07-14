/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.model.FacturaEmpresa;
import com.teamj.arquitectura.publicidad.services.FacturaEmpresaService;
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
@Path("facturaEmpresa")
@RequestScoped
public class FacturaEmpresaResource {

    @Context
    private UriInfo context;
    @EJB
    private FacturaEmpresaService facturaEmpresaService;

    /**
     * Creates a new instance of FacturaEmpresaResource
     */
    public FacturaEmpresaResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveFacturaEmp")
    public List<com.teamj.arquitectura.publicidad.model.FacturaEmpresa> retrieveFacturaEmp() {
        //TODO return proper representation object
        return facturaEmpresaService.retrieveFacturaEmp();        
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarFacturaEmp")
    public boolean registrarFacturaEmp(com.teamj.arquitectura.publicidad.model.FacturaEmpresa content) {
        return facturaEmpresaService.registrarFacturaEmp(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarFacturaEmp")
    public boolean editarFacturaEmp(com.teamj.arquitectura.publicidad.model.FacturaEmpresa content) {
        return facturaEmpresaService.editarFacturaEmp(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarFacturaEmp")
    public void eliminarFacturaEmp(com.teamj.arquitectura.publicidad.model.FacturaEmpresa content) {
        facturaEmpresaService.eliminarFacturaEmp(content.getId());
    }
}
