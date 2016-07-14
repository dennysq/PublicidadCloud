/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.services;

import com.teamj.arquitectura.publicidad.dao.UsuarioDAO;
import com.teamj.arquitectura.publicidad.model.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@Stateless
@LocalBean
public class UsuarioServicio {
    @EJB
    private UsuarioDAO usuarioDAO;
    
    public Usuario obtenerPorId(Integer id) {
        return this.usuarioDAO.findById(id, false);
    }
    public List<Usuario> retrieveUsers() {
        return this.usuarioDAO.findAll();
    }
    
    
    
    
}
