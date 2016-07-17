/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.SegmentoDetalleCampaniaDAO;
import com.teamj.arquitectura.publicidad.model.SegmentoDetalleCampania;
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
public class SegmentoDetalleCampaniaServicio {
    @EJB
    private SegmentoDetalleCampaniaDAO segmentoDetalleCampaniaDAO;
    
    public List<SegmentoDetalleCampania> retrieveDetalleCampaniaServ() {
        return this.segmentoDetalleCampaniaDAO.findAll();
    }
    
    public boolean registrarDetalleCampaniaServ(SegmentoDetalleCampania sdc) throws ValidationException {
        boolean flag = false;
        SegmentoDetalleCampania temp = new SegmentoDetalleCampania();

        try {
//            temp.setSegmentoDetalleCampaniaPK(sdc.getSegmentoDetalleCampaniaPK().getSecCampania(),sdc.getSegmentoDetalleCampaniaPK().getIdElemento());
            temp.setCampania(sdc.getCampania());
            temp.setElemento(sdc.getElemento());
            temp.setTargetEdad(sdc.getTargetEdad());
            temp.setHoraInicio(sdc.getHoraInicio());
            temp.setHoraFin(sdc.getHoraFin());
            
            segmentoDetalleCampaniaDAO.insert(temp);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al registrar", e);
        }
        return flag;
    }
    
    public boolean editarDetalleCampaniaServ(SegmentoDetalleCampania sdc) throws ValidationException {
        boolean flag = false;
        try {
            this.segmentoDetalleCampaniaDAO.update(sdc);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar", e);
        }
        return flag;
    }
    
    public void eliminarDetalleCampaniaServ(Integer id) {
        SegmentoDetalleCampania temp = this.segmentoDetalleCampaniaDAO.findById(id, false);
        if (temp != null) {
            this.segmentoDetalleCampaniaDAO.remove(temp);
        }
    }
}
