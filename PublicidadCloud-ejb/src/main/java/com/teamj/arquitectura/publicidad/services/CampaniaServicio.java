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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    private SimpleDateFormat sdf;
    
    public List<Campania> retrieveCampania() {
        
        Campania temp = new Campania();
        List<Campania> tempList = this.campaniaDAO.find(temp);
//        if (tempList != null && tempList.size() == 1) {
//            if (c.getEmpresa().getRuc().equals(tempList.get(0).getRuc())) {
//                temp.setEmpresa(c.getEmpresa());
//            }
//        }
        return this.campaniaDAO.findAll();
    }
    
    public boolean registrarCampania(Empresa empresa, String nombre,String descripcion, String fechaC, String fechaI, String fechaF, String estado) throws ValidationException {
        boolean flag = false;
        Campania temp = new Campania();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Empresa tempEmp = new Empresa();
//        tempEmp.setRuc(c.getEmpresa().getRuc());
//
//        List<Empresa> tempList = this.empresaDAO.find(tempEmp);
//        if (tempList != null && tempList.size() == 1) {
//            if (c.getEmpresa().getRuc().equals(tempList.get(0).getRuc())) {
//                temp.setEmpresa(c.getEmpresa());
//            }
//        }
        try 
        {
            Date cfechaC = sdf.parse(fechaC);
            Date cfechaI = sdf.parse(fechaI);
            Date cfechaF = sdf.parse(fechaF);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        try {
            
            temp.setEmpresa(empresa);
            temp.setNombre(nombre);
            temp.setDescripcion(descripcion);
//            temp.setFechaCreacion(cfechaC);
//            temp.setFechaInicio(cfechaI);
//            temp.setFechaFin(cfechaF);
            temp.setEstado(estado);
            campaniaDAO.insert(temp);
        } catch (Exception e) {
            throw new ValidationException("Error al editar Campania", e);
        }
        return flag;
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
