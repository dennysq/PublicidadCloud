/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.CampaniaDAO;
import com.teamj.arquitectura.publicidad.dao.DetalleCampaniaDAO;
import com.teamj.arquitectura.publicidad.dao.ElementoDAO;
import com.teamj.arquitectura.publicidad.model.Campania;
import com.teamj.arquitectura.publicidad.model.DetalleCampania;
import com.teamj.arquitectura.publicidad.model.DetalleCampaniaPK;
import com.teamj.arquitectura.publicidad.model.Elemento;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.ValidationException;

/**
 *
 * @author Klever
 */
@Stateless
@LocalBean
public class DetalleCampaniaServicio implements Serializable{
    @EJB
    private DetalleCampaniaDAO detalleCampaniaDAO;
    @EJB
    private ElementoDAO elementoDAO;
    @EJB
    private CampaniaDAO campaniaDAO;
    
    public DetalleCampania obtenerPorId(DetalleCampaniaPK id) {
        return this.detalleCampaniaDAO.findById(id, false);
    }
    
    public List<DetalleCampania> retrieveDetalleCamp() {
        return this.detalleCampaniaDAO.findAll();
    }
    
    public boolean registrarDetalleCamp(DetalleCampania dc) throws ValidationException {
        boolean flag = false;
        
        DetalleCampania temp = new DetalleCampania();
        DetalleCampania temp2 = new DetalleCampania();
        Campania tempCamp = new Campania();
        Elemento tempElem = new Elemento();
        
        tempCamp.setSec(dc.getCampania().getSec());
        tempElem.setId(dc.getElemento().getId());

        List<Campania> tempListC = this.campaniaDAO.find(tempCamp);
        List<Elemento> tempListE = this.elementoDAO.find(tempElem);
        
        if (tempListC != null && tempListC.size() == 1 && tempListE != null && tempListE.size() == 1){//buscar campania y elemento
        try {
            DetalleCampaniaPK detalleCampaniaPK=new DetalleCampaniaPK();
            
            detalleCampaniaPK.setSecCampania(dc.getCampania().getSec());
            detalleCampaniaPK.setIdElemento(dc.getElemento().getId());
            
            temp.setDetalleCampaniaPK(detalleCampaniaPK);
            
            if(obtenerPorId(detalleCampaniaPK)==null){
            temp.setDespligues(dc.getDespligues());
            temp.setClics(dc.getClics());
            temp.setModoFacturacion(dc.getModoFacturacion());
            temp.setCampania(dc.getCampania());
            temp.setElemento(dc.getElemento());
            detalleCampaniaDAO.insert(temp);
            flag = true;
            }
        } catch (Exception e) {
            throw new ValidationException("Error al registrar", e);
        }
        }
        return flag;
    }
    
    public boolean editarDetalleCamp(DetalleCampania dc) throws ValidationException {
        boolean flag = false;
        try {
            this.detalleCampaniaDAO.update(dc);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar", e);
        }
        return flag;
    }
    
    public void eliminarDetalleCamp(DetalleCampania dc) {
        List<DetalleCampania> tempList = this.detalleCampaniaDAO.find(dc);
        if (tempList != null && tempList.size() == 1) {
            this.detalleCampaniaDAO.remove(dc);
        }
    }
}
