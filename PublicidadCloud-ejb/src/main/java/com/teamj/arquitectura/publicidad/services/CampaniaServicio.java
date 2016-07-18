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
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class CampaniaServicio implements Serializable{
    @EJB
    private CampaniaDAO campaniaDAO;
    @EJB
    private EmpresaDAO empresaDAO;
    
    private SimpleDateFormat sdf;
    
    public List<Campania> retrieveCampania() {
           
       return  this.campaniaDAO.findAll();
    }
    
    public boolean registrarCampania(String ruc, String nombre,String descripcion, String fechaC, String fechaI, String fechaF, String estado) throws ValidationException {
        boolean flag = false;
        Campania temp = new Campania();
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        Empresa tempEmp = new Empresa();
        tempEmp.setRuc(ruc);

        List<Empresa> tempList = this.empresaDAO.find(tempEmp);
        if (tempList != null && tempList.size() == 1){//buscar la empresa
        try {
            temp.setRuc(ruc);
            temp.setNombre(nombre);
            temp.setDescripcion(descripcion);
            temp.setFechaCreacion(sdf.parse(fechaC));
            temp.setFechaInicio(sdf.parse(fechaI));
            //temp.setFechaFin(sdf.parse(fechaF));
            temp.setEstado(estado);
            campaniaDAO.insert(temp);
        } catch (Exception e) {
            throw new ValidationException("Error al editar Campania", e);
        }
        
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
