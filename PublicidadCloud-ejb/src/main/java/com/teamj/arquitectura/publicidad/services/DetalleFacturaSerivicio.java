/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.DetalleFacturaDAO;
import com.teamj.arquitectura.publicidad.model.DetalleFactura;
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
public class DetalleFacturaSerivicio implements Serializable{
    @EJB
    private DetalleFacturaDAO detalleFacturaDAO;
    
    public List<DetalleFactura> retrieveDetalleFactura() {
        return this.detalleFacturaDAO.findAll();
    }
    
    public boolean registrarDetalleFactura(DetalleFactura df) throws ValidationException {
        boolean flag = false;
        try {
            DetalleFactura temp = new DetalleFactura();
            temp.setFacturaEmpresa(df.getFacturaEmpresa());
            temp.setCodigoProducto(df.getCodigoProducto());
            temp.setCantidad(df.getCantidad());
            temp.setDescripcion(df.getDescripcion());
            temp.setValorUnitario(df.getValorUnitario());
            temp.setValorTotal(df.getValorTotal());
            temp.setValorDescuento(df.getValorDescuento());

            detalleFacturaDAO.insert(temp);
             flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al crear una nueva empresa", e);
        }
        return flag;
    }
    
    public boolean editarDetalleFactura(DetalleFactura df) throws ValidationException {
        boolean flag = false;
        try {
            this.detalleFacturaDAO.update(df);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar el detalle de la Empresa", e);
        }
        return flag;
    }
    
    public void eliminarDetalleFactura(Integer id) {
        DetalleFactura temp = this.detalleFacturaDAO.findById(id, false);
        if (temp != null) {
            this.detalleFacturaDAO.remove(temp);
        }
    }
}
