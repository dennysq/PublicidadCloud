/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.EmpresaDAO;
import com.teamj.arquitectura.publicidad.model.Empresa;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.ValidationException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Klever
 */
@Stateless
@LocalBean
public class EmpresaServicio {
    @EJB
    private EmpresaDAO empresaDAO;
    
    public List<Empresa> retrieveEmp() {
        return this.empresaDAO.findAll();
    }
    
    public boolean registrarEmp(Empresa emp) throws ValidationException {
        boolean flag = false;
        Empresa temp = new Empresa();

        temp.setRuc(emp.getRuc());

        List<Empresa> tempList = this.empresaDAO.find(temp);
        if (tempList == null || tempList.isEmpty()) {//el ruc de empresa no existe
            try {

                temp.setRazonSocial(emp.getRazonSocial());
                temp.setEmail(emp.getEmail());
                temp.setTelefono(emp.getTelefono());
                temp.setDireccion(emp.getDireccion());
                temp.setRepresentante(emp.getRepresentante());

                empresaDAO.insert(temp);

                flag = true;
            } catch (Exception e) {
                throw new ValidationException("Error al crear una nueva empresa", e);
            }
        }
        return flag;
    }
    
    public boolean editarEmp(Empresa emp) throws ValidationException {
        boolean flag = false;
        try {
            this.empresaDAO.update(emp);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar la empresa", e);
        }
        return flag;
    }
    
    public void eliminarEmp(String ruc) {
        Empresa temp = this.empresaDAO.findById(ruc, false);
        if (temp != null) {
            this.empresaDAO.remove(temp);
        }
    }
    
    public boolean buscarEmp(Empresa emp){
        Empresa tempEmp = new Empresa();
        boolean flag = false;
        tempEmp.setRuc(emp.getRuc());

        List<Empresa> tempList = this.empresaDAO.find(tempEmp);
        if (tempList != null && tempList.size() == 1) {
            if (emp.getRuc().equals(tempList.get(0).getRuc())) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }
}
