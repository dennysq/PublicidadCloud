/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.publicidad.model.EstadisticaCampania;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@LocalBean
@Stateless
public class EstadisticaCampaniaDAO extends DefaultGenericDAOImple<EstadisticaCampania, Integer>{
    public EstadisticaCampaniaDAO() {
            super(EstadisticaCampania.class);
    }
}
