/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.CampaniaDAO;
import com.teamj.arquitectura.publicidad.dao.EstadisticaCampaniaDAO;
import com.teamj.arquitectura.publicidad.model.Campania;
import com.teamj.arquitectura.publicidad.model.EstadisticaCampania;
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
public class EstadisticaCampaniaServicio implements Serializable{
    @EJB
    private EstadisticaCampaniaDAO estadisticaCampaniaDAO;
    @EJB
    private CampaniaDAO campaniaDAO;
    
    public List<EstadisticaCampania> retrieveEstadisticaServ() {
        return this.estadisticaCampaniaDAO.findAll();
    }
    
    public boolean registrarEstadisticaServ(EstadisticaCampania ec) throws ValidationException {
        boolean flag = false;
        EstadisticaCampania temp = new EstadisticaCampania();
        Campania tempCamp = new Campania();
        
        tempCamp.setSec(ec.getCampania().getSec());

        List<Campania> tempList = this.campaniaDAO.find(tempCamp);
        if (tempList != null && tempList.size() == 1){//buscar la campania
        try {
            temp.setCampania(ec.getCampania());
            temp.setDespligues(ec.getDespligues());
            temp.setClics(ec.getClics());
            estadisticaCampaniaDAO.insert(temp);
            flag=true;
        } catch (Exception e) {
            throw new ValidationException("Error al registrar", e);
        }
        }
        return flag;
    }
     
    public boolean editarEstadisticaServ(EstadisticaCampania ec) throws ValidationException {
        boolean flag = false;
        try {
            this.estadisticaCampaniaDAO.update(ec);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar la EstadisticaCampania", e);
        }
        return flag;
    }
    
    public void eliminarEstadisticaServ(Integer sec) {
        EstadisticaCampania temp = this.estadisticaCampaniaDAO.findById(sec, false);
        if (temp != null) {
            this.estadisticaCampaniaDAO.remove(temp);
        }
    }
}
