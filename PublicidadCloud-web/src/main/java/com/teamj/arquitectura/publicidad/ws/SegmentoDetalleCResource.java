/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import com.teamj.arquitectura.publicidad.services.SegmentoDetalleCampaniaServicio;
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
@Path("segmentoDetalleC")
@RequestScoped
public class SegmentoDetalleCResource {

    @Context
    private UriInfo context;
    
    @EJB
    SegmentoDetalleCampaniaServicio segmentoDetalleCampaniaServicio;

    /**
     * Creates a new instance of SegmentoDetalleCResource
     */
    public SegmentoDetalleCResource() {
    }

    /**
     * Retrieves representation of an instance of com.teamj.arquitectura.publicidad.ws.SegmentoDetalleCResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/retrieveSegmentoDetalleCamp")
    public List<com.teamj.arquitectura.publicidad.model.SegmentoDetalleCampania> retrieveSegmentoDetalleCamp() {
        //TODO return proper representation object
        return segmentoDetalleCampaniaServicio.retrieveSegmentoDetalleCampServ();
    }
    
     @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrarSegmentoDetalleCamp")
    public boolean registrarSegmentoDetalleCamp(com.teamj.arquitectura.publicidad.model.SegmentoDetalleCampania content) {
        return segmentoDetalleCampaniaServicio.registrarSegmentoDetalleCampServ(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarSegmentoDetalleCamp")
    public boolean editarSegmentoDetalleCamp(com.teamj.arquitectura.publicidad.model.SegmentoDetalleCampania content) {
        return segmentoDetalleCampaniaServicio.editarSegmentoDetalleCampServ(content);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminarSegmentoDetalleCamp")
    public void eliminarSegmentoDetalleCamp(com.teamj.arquitectura.publicidad.model.SegmentoDetalleCampania content) {
        segmentoDetalleCampaniaServicio.eliminarSegmentoDetalleCampServ(content);
    }
    
}
