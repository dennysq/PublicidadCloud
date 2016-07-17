/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.EmpresaDAO;
import com.teamj.arquitectura.publicidad.dao.TargetEdadDAO;
import com.teamj.arquitectura.publicidad.model.Empresa;
import com.teamj.arquitectura.publicidad.model.TargetEdad;
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
public class TargetEdadServicio implements Serializable{
    @EJB
    private TargetEdadDAO targetEdadDAO;
    @EJB
    private EmpresaDAO empresaDAO;
    
    public List<TargetEdad> retrieveTargetE() {
        return this.targetEdadDAO.findAll();
    }
    
    public boolean registrarTargetE(TargetEdad te) throws ValidationException {
        boolean flag = false;
        TargetEdad temp = new TargetEdad();        
        Empresa tempE = new Empresa();
        
        tempE.setRuc(te.getRuc());

        List<Empresa> tempList = this.empresaDAO.find(tempE);
        if (tempList != null && tempList.size() == 1){//buscar la empresa
        try {
            temp.setRuc(te.getRuc());
            temp.setNombre(te.getNombre());
            temp.setDescripcion(te.getDescripcion());
            temp.setEdadMinima(te.getEdadMinima());
            temp.setEdadMaxima(te.getEdadMaxima());
            temp.setGenero(te.getGenero());
            targetEdadDAO.insert(temp);
            flag=true;
        } catch (Exception e) {
            throw new ValidationException("Error al registrar", e);
        }
        }
        return flag;
    }
    
    public boolean editarTargetE(TargetEdad te) throws ValidationException {
        boolean flag = false;
        try {
            this.targetEdadDAO.update(te);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar Target Edad", e);
        }
        return flag;
    }
    
    public void eliminarTargetE(Integer id) {
        TargetEdad temp = this.targetEdadDAO.findById(id, false);
        if (temp != null) {
            this.targetEdadDAO.remove(temp);
        }
    }
}
