/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Klever
 */
@Embeddable
public class SegmentoDetalleCampaniaPK implements Serializable{
    
    @Column(name = "SEC_CAMPANIA")
    private Integer secCampania;
     
    @Column(name = "ID_ELEMENTO")
    private Integer idElemento;

    public SegmentoDetalleCampaniaPK() {
    }

    public SegmentoDetalleCampaniaPK(Integer secCampania, Integer idElemento) {
        this.secCampania = secCampania;
        this.idElemento = idElemento;
    }

    public Integer getSecCampania() {
        return secCampania;
    }

    public void setSecCampania(Integer secCampania) {
        this.secCampania = secCampania;
    }

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.secCampania);
        hash = 11 * hash + Objects.hashCode(this.idElemento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SegmentoDetalleCampaniaPK other = (SegmentoDetalleCampaniaPK) obj;
        if (!Objects.equals(this.secCampania, other.secCampania)) {
            return false;
        }
        if (!Objects.equals(this.idElemento, other.idElemento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegmentoDetalleCampaniaPK{" + "secCampania=" + secCampania + ", idElemento=" + idElemento + '}';
    }
    
    
    
}
