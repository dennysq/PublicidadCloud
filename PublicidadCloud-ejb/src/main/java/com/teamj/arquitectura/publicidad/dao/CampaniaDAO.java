/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.publicidad.model.Campania;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Dennys
 */
@LocalBean
@Stateless
public class CampaniaDAO extends DefaultGenericDAOImple<Campania, Integer>{
    public CampaniaDAO() {
            super(Campania.class);
    }
    
}
