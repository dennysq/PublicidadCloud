/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.ElementoDAO;
import com.teamj.arquitectura.publicidad.model.Elemento;
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
public class ElementoServicio {
    @EJB
    private ElementoDAO elementoDAO;
    
    public List<Elemento> retrieveElem(){
        return this.elementoDAO.findAll();
    }
    
    public void registrarElem(Elemento elem) throws ValidationException {
        boolean flag = false;
        Elemento temp = new Elemento();

        temp.setNombre(elem.getNombre());
        temp.setPosicion(elem.getPosicion());
        temp.setUrl(elem.getUrl());
        temp.setPath(elem.getPath());
       
        elementoDAO.insert(temp);
    }
    
    public boolean editarElem(Elemento elem) throws ValidationException {
        boolean flag = false;
        try {
            this.elementoDAO.update(elem);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar el elemento", e);
        }
        return flag;
    }
    
    public void eliminarElem(Integer id) {
        Elemento temp = this.elementoDAO.findById(id, false);
        if (temp != null) {
            this.elementoDAO.remove(temp);
        }
    }
    
    

}
