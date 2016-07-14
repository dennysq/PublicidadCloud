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
import javax.validation.ValidationException;
import org.apache.commons.codec.digest.DigestUtils;

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
    
    public void registrarUsu(Usuario u) throws ValidationException {
        //boolean flag = false;
        Usuario temp = new Usuario();
        
        temp.setUsername(u.getUsername());
        String codecPassword = DigestUtils.md5Hex(u.getPassword());
        temp.setPassword(codecPassword);
        temp.setNombres(u.getNombres());
        usuarioDAO.insert(temp);
        //temp.setId(u.getId());

//        List<Usuario> tempList = this.usuarioDAO.find(temp);
//        if (tempList == null || tempList.isEmpty()) {//el ruc de empresa no existe
//            try {
//
//                temp.setUsername(u.getUsername());
//                String codecPassword = DigestUtils.md5Hex(u.getPassword());
//                temp.setNombres(u.getNombres());
//                
//                usuarioDAO.insert(temp);
//
//                flag = true;
//            } catch (Exception e) {
//                throw new ValidationException("Error al crear un nuevo usuario", e);
//            }
//        }
        //return flag;
    }
    
    public boolean editarUsu(Usuario u) throws ValidationException {
        boolean flag = false;
        try {
            this.usuarioDAO.update(u);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar al usuario", e);
        }
        return flag;
    }
    
    public void eliminarUsu(Integer id) {
        Usuario temp = this.usuarioDAO.findById(id, false);
        if (temp != null) {
            this.usuarioDAO.remove(temp);
        }
    }
    
}
