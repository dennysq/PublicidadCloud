/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.CampaniaDAO;
import com.teamj.arquitectura.publicidad.dao.ElementoDAO;
import com.teamj.arquitectura.publicidad.dao.SegmentoDetalleCampaniaDAO;
import com.teamj.arquitectura.publicidad.dao.TargetEdadDAO;
import com.teamj.arquitectura.publicidad.model.Campania;
import com.teamj.arquitectura.publicidad.model.DetalleCampaniaPK;
import com.teamj.arquitectura.publicidad.model.Elemento;
import com.teamj.arquitectura.publicidad.model.SegmentoDetalleCampania;
import com.teamj.arquitectura.publicidad.model.SegmentoDetalleCampaniaPK;
import com.teamj.arquitectura.publicidad.model.TargetEdad;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.swing.text.html.parser.TagElement;
import javax.validation.ValidationException;

/**
 *
 * @author Klever
 */
@Stateless
@LocalBean
public class SegmentoDetalleCampaniaServicio implements Serializable{
    @EJB
    private SegmentoDetalleCampaniaDAO segmentoDetalleCampaniaDAO;
    @EJB
    private ElementoDAO elementoDAO;
    @EJB
    private CampaniaDAO campaniaDAO;
    @EJB
    private TargetEdadDAO targetEdadDAO;
    
    public SegmentoDetalleCampania obtenerPorId(SegmentoDetalleCampaniaPK id) {
        return this.segmentoDetalleCampaniaDAO.findById(id, false);
    }
    
    public List<SegmentoDetalleCampania> retrieveSegmentoDetalleCampServ() {
        return this.segmentoDetalleCampaniaDAO.findAll();
    }
    
    public boolean registrarSegmentoDetalleCampServ(SegmentoDetalleCampania sdc) throws ValidationException {
        boolean flag = false;
        SegmentoDetalleCampania temp = new SegmentoDetalleCampania();
        
        Campania tempCamp = new Campania();
        Elemento tempElem = new Elemento();
        TargetEdad tempTar = new TargetEdad();

        tempCamp.setSec(sdc.getCampania().getSec());
        tempElem.setId(sdc.getElemento().getId());
        tempTar.setId(sdc.getTargetEdad().getId());

        List<Campania> tempListC = this.campaniaDAO.find(tempCamp);
        List<Elemento> tempListE = this.elementoDAO.find(tempElem);
        List<TargetEdad> tempListT = this.targetEdadDAO.find(tempTar);
        
        if (tempListC != null && tempListC.size() == 1 && tempListE != null && tempListE.size() == 1 &&
               tempListT != null && tempListT.size() == 1 ){//buscar campania, elemento y target
         
        try {
            SegmentoDetalleCampaniaPK segmentoDetalleCampaniaPK=new SegmentoDetalleCampaniaPK();
            
            segmentoDetalleCampaniaPK.setSecCampania(sdc.getCampania().getSec());
            segmentoDetalleCampaniaPK.setIdElemento(sdc.getElemento().getId());
            
            temp.setSegmentoDetalleCampaniaPK(segmentoDetalleCampaniaPK);
            
            if(obtenerPorId(segmentoDetalleCampaniaPK)==null){
            temp.setTargetEdad(sdc.getTargetEdad());
            temp.setHoraInicio(sdc.getHoraInicio());
            temp.setHoraFin(sdc.getHoraFin());
            temp.setMaximoHora(sdc.getMaximoHora());
            temp.setMinimoHora(sdc.getMinimoHora());

            temp.setCampania(sdc.getCampania());
            temp.setElemento(sdc.getElemento());
            segmentoDetalleCampaniaDAO.insert(temp);
            
            flag = true;
            }
        } catch (Exception e) {
            throw new ValidationException("Error al registrar", e);
        }
        }
        return flag;
    }
    
    public boolean editarSegmentoDetalleCampServ(SegmentoDetalleCampania sdc) throws ValidationException {
        boolean flag = false;
        try {
            this.segmentoDetalleCampaniaDAO.update(sdc);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar", e);
        }
        return flag;
    }
    
    public void eliminarSegmentoDetalleCampServ(SegmentoDetalleCampania sdc) {

        SegmentoDetalleCampaniaPK detalleCampaniaPK=new SegmentoDetalleCampaniaPK();
        detalleCampaniaPK.setSecCampania(sdc.getCampania().getSec());
        detalleCampaniaPK.setIdElemento(sdc.getElemento().getId());
        
        SegmentoDetalleCampania tempSDC = obtenerPorId(detalleCampaniaPK);
            
            //if(obtenerPorId(detalleCampaniaPK)==null)
        if (tempSDC!=null) {
            this.segmentoDetalleCampaniaDAO.remove(tempSDC);
        }
    }
}
