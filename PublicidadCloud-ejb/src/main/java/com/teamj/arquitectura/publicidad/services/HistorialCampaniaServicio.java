/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.HistorialCampaniaDAO;
import com.teamj.arquitectura.publicidad.model.HistorialCampania;
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
public class HistorialCampaniaServicio implements Serializable{
    @EJB
    private HistorialCampaniaDAO historialCampaniaDAO;
    
    public List<HistorialCampania> retrieveHistorialCamp() {
        return this.historialCampaniaDAO.findAll();
    }
    
    public boolean registrarHistorialCamp(HistorialCampania hc) throws ValidationException {
        boolean flag = false;
        HistorialCampania temp = new HistorialCampania();

        try {
            temp.setId(hc.getId());
            temp.setCampania(hc.getCampania());
            temp.setFechaCompra(hc.getFechaCompra());
            temp.setClics(hc.getClics());
            temp.setCostoClic(hc.getCostoClic());
            temp.setDespligues(hc.getDespligues());
            temp.setCostoDespligue(hc.getCostoDespligue());

            historialCampaniaDAO.insert(temp);

            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al registrar", e);
        }
        return flag;
    }
    
    public boolean editarHistorialCamp(HistorialCampania hc) throws ValidationException {
        boolean flag = false;
        try {
            this.historialCampaniaDAO.update(hc);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar", e);
        }
        return flag;
    }
    
    public void eliminarHistorialCamp(Integer id) {
        HistorialCampania temp = this.historialCampaniaDAO.findById(id, false);
        if (temp != null) {
            this.historialCampaniaDAO.remove(temp);
        }
    }
}
