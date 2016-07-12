/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.publicidad.model.DetalleCampania;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@LocalBean
@Stateless
public class DetalleCampaniaDAO extends DefaultGenericDAOImple<DetalleCampania, Integer>{
    public DetalleCampaniaDAO() {
            super(DetalleCampania.class);
    }
}
