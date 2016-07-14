/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.CampaniaDAO;
import com.teamj.arquitectura.publicidad.dao.EmpresaDAO;
import com.teamj.arquitectura.publicidad.model.Campania;
import com.teamj.arquitectura.publicidad.model.Empresa;
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
public class CampaniaServicio {
    @EJB
    private CampaniaDAO campaniaDAO;
    @EJB
    private EmpresaDAO empresaDAO;
    
    public List<Campania> retrieveCampania() {
        return this.campaniaDAO.findAll();
    }
    
    public void registrarCampania(Campania c) throws ValidationException {
        //boolean flag = false;
        Campania temp = new Campania();
        
//        Empresa tempEmp = new Empresa();
//        tempEmp.setRuc(c.getEmpresa().getRuc());
//
//        List<Empresa> tempList = this.empresaDAO.find(tempEmp);
//        if (tempList != null && tempList.size() == 1) {
//            if (c.getEmpresa().getRuc().equals(tempList.get(0).getRuc())) {
//                temp.setEmpresa(c.getEmpresa());
//            }
//        }
System.out.println("----------------------------------------FECHAS-----------------------------");
        System.out.println("FECHAAAAAAAAAAAAAAA----------->>>>>"+c.getFechaCreacion());
        System.out.println(c.getFechaFin());
        System.out.println(c.getFechaInicio());
        
        temp.setEmpresa(c.getEmpresa());
        temp.setNombre(c.getNombre());
        temp.setDescripcion(c.getDescripcion());
        temp.setFechaCreacion(c.getFechaCreacion());
        temp.setFechaInicio(c.getFechaInicio());
        temp.setFechaFin(c.getFechaFin());
        temp.setEstado(c.getEstado());
        

        campaniaDAO.insert(temp);
    }
    
    public boolean editarCampania(Campania c) throws ValidationException {
        boolean flag = false;
        try {
            this.campaniaDAO.update(c);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar Campania", e);
        }
        return flag;
    }
    
    public void eliminarCampania(Integer sec) {
        Campania temp = this.campaniaDAO.findById(sec, false);
        if (temp != null) {
            this.campaniaDAO.remove(temp);
        }
    }
}
