/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.DetalleCampaniaDAO;
import com.teamj.arquitectura.publicidad.model.DetalleCampania;
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
public class DetalleCampaniaServicio {
    @EJB
    private DetalleCampaniaDAO detalleCampaniaDAO;
    
    public List<DetalleCampania> retrieveDetalleCamp() {
        return this.detalleCampaniaDAO.findAll();
    }
    
    public boolean registrarDetalleCamp(DetalleCampania dc) throws ValidationException {
        boolean flag = false;
        DetalleCampania temp = new DetalleCampania();

        try {
            temp.setDetalleCampaniaPK(dc.getDetalleCampaniaPK());
            temp.setCampania(dc.getCampania());
            temp.setElemento(dc.getElemento());
            temp.setDespligues(dc.getDespligues());
            temp.setClics(dc.getClics());
            temp.setModoFacturacion(dc.getModoFacturacion());
            detalleCampaniaDAO.insert(temp);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al registrar", e);
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
    
    public void eliminarDetalleCamp(Integer id) {
        DetalleCampania temp = this.detalleCampaniaDAO.findById(id, false);
        if (temp != null) {
            this.detalleCampaniaDAO.remove(temp);
        }
    }
}
