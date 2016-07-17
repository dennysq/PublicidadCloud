/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.FacturaEmpresaDAO;
import com.teamj.arquitectura.publicidad.model.FacturaEmpresa;
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
public class FacturaEmpresaServicio implements Serializable{
    @EJB
    private FacturaEmpresaDAO facturaEmpresaDAO;
    
     public List<FacturaEmpresa> retrieveFacturaEmp(){
        return this.facturaEmpresaDAO.findAll();
    }
     
    public boolean registrarFacturaEmp(FacturaEmpresa fe) throws ValidationException {
        boolean flag = false;
        FacturaEmpresa temp = new FacturaEmpresa();
        try {
            temp.setEmpresa(fe.getEmpresa());
            temp.setFecha_emision(fe.getFecha_emision());
            temp.setSecuencial(fe.getSecuencial());
            temp.setDireccion(fe.getDireccion());
            temp.setTelefono(fe.getTelefono());
            temp.setValorTotal(fe.getValorTotal());
            temp.setPorcentajeIva(fe.getPorcentajeIva());
            temp.setSubtotal(fe.getSubtotal());

            facturaEmpresaDAO.insert(temp);
        } catch (Exception e) {
            throw new ValidationException("Error al registrar", e);
        }
        return flag;
    }
    
    public boolean editarFacturaEmp(FacturaEmpresa fe) throws ValidationException {
        boolean flag = false;
        try {
            this.facturaEmpresaDAO.update(fe);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar la empresa", e);
        }
        return flag;
    }
    
    public void eliminarFacturaEmp(Integer id) {
        FacturaEmpresa temp = this.facturaEmpresaDAO.findById(id, false);
        if (temp != null) {
            this.facturaEmpresaDAO.remove(temp);
        }
    }
}
