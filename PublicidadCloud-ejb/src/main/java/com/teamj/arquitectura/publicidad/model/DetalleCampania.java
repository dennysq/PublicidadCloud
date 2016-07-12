/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "DETALLE_CAMPANIA")
public class DetalleCampania implements Serializable{
    
    @EmbeddedId
    DetalleCampaniaPK detalleCampaniaPK;
    
    @ManyToOne
    @JoinColumn(name = "SEC_CAMPANIA", nullable = false,insertable = false,updatable = false)
    private Campania campania;

    @ManyToOne
    @JoinColumn(name = "ID_ELEMENTO", nullable = false,insertable = false,updatable = false)
    private Elemento elemento;
     
    @Column(name = "DESPLIEGUES")
    private Integer despligues;
    
    @Column(name = "CLICS")
    private Integer clics;
    
    @Column(name = "MODO_FACTURACION")
    private String modoFacturacion;

    public DetalleCampania() {
    }

    public DetalleCampaniaPK getDetalleCampaniaPK() {
        return detalleCampaniaPK;
    }

    public void setDetalleCampaniaPK(DetalleCampaniaPK detalleCampaniaPK) {
        this.detalleCampaniaPK = detalleCampaniaPK;
    }

    public Campania getCampania() {
        return campania;
    }

    public void setCampania(Campania campania) {
        this.campania = campania;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public Integer getDespligues() {
        return despligues;
    }

    public void setDespligues(Integer despligues) {
        this.despligues = despligues;
    }

    public Integer getClics() {
        return clics;
    }

    public void setClics(Integer clics) {
        this.clics = clics;
    }

    public String getModoFacturacion() {
        return modoFacturacion;
    }

    public void setModoFacturacion(String modoFacturacion) {
        this.modoFacturacion = modoFacturacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.detalleCampaniaPK);
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
        final DetalleCampania other = (DetalleCampania) obj;
        if (!Objects.equals(this.detalleCampaniaPK, other.detalleCampaniaPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleCampania{" + "detalleCampaniaPK=" + detalleCampaniaPK + ", despligues=" + despligues + ", clics=" + clics + ", modoFacturacion=" + modoFacturacion + '}';
    }

}
