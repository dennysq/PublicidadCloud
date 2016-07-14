/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.FacturaEmpresaDAO;
import com.teamj.arquitectura.publicidad.model.FacturaEmpresa;
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
public class FacturaEmpresaService {
    @EJB
    private FacturaEmpresaDAO facturaEmpresaDAO;
    
     public List<FacturaEmpresa> retrieveFacturaEmp(){
        return this.facturaEmpresaDAO.findAll();
    }
     
    public void registrarFacturaEmp(FacturaEmpresa fe) throws ValidationException {
        boolean flag = false;
        FacturaEmpresa temp = new FacturaEmpresa();

        temp.setFecha_emision(fe.getFecha_emision());
        temp.setSecuencial(fe.getSecuencial());
        temp.setDireccion(fe.getDireccion());
        temp.setTelefono(fe.getTelefono());
        temp.setValor_total(fe.getValor_total());
        temp.setPorcentajeIva(fe.getPorcentajeIva());
        temp.setSubtotal(fe.getSubtotal());

        facturaEmpresaDAO.insert(temp);
    }
}
