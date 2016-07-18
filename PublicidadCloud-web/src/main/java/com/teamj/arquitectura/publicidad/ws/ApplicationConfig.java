/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Andres
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.teamj.arquitectura.publicidad.ws.CampaniaResource.class);
        resources.add(com.teamj.arquitectura.publicidad.ws.DetalleCampaniaResource.class);
        resources.add(com.teamj.arquitectura.publicidad.ws.DetalleFacturaResource.class);
        resources.add(com.teamj.arquitectura.publicidad.ws.ElementoResource.class);
        resources.add(com.teamj.arquitectura.publicidad.ws.EmpresaResource.class);
        resources.add(com.teamj.arquitectura.publicidad.ws.EstadisticaCampaniaResource.class);
        resources.add(com.teamj.arquitectura.publicidad.ws.FacturaEmpresaResource.class);
        resources.add(com.teamj.arquitectura.publicidad.ws.HistorialCampaniaResource.class);
        resources.add(com.teamj.arquitectura.publicidad.ws.SegmentoDetalleCResource.class);
        resources.add(com.teamj.arquitectura.publicidad.ws.TargetEdadResource.class);
        resources.add(com.teamj.arquitectura.publicidad.ws.UsuarioResource.class);
    }
    
}
