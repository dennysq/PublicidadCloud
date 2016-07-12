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
@Table(name = "SEGMENTO_DETALLE_CAMPANIA")
public class SegmentoDetalleCampania implements Serializable{
    
    @EmbeddedId
    SegmentoDetalleCampaniaPK segmentoDetalleCampaniaPK;
    
    @ManyToOne
    @JoinColumn(name = "SEC_CAMPANIA", nullable = false,insertable = false,updatable = false)
    private Campania campania;

    @ManyToOne
    @JoinColumn(name = "ID_ELEMENTO", nullable = false,insertable = false,updatable = false)
    private Elemento elemento;
    
    @ManyToOne
    @JoinColumn(name = "ID_TARGET_EDAD")
    private TargetEdad targetEdad;
    
    @Column(name = "HORA_INICIO")
    private String horaInicio;
    
    @Column(name = "HORA_FIN")
    private String horaFin;
    
    @Column(name = "MAXIMO_HORA")
    private String maximoHora;
    
    @Column(name = "MINIMO_HORA")
    private String minimoHora;

    public SegmentoDetalleCampania() {
    }

    public SegmentoDetalleCampaniaPK getSegmentoDetalleCampaniaPK() {
        return segmentoDetalleCampaniaPK;
    }

    public void setSegmentoDetalleCampaniaPK(SegmentoDetalleCampaniaPK segmentoDetalleCampaniaPK) {
        this.segmentoDetalleCampaniaPK = segmentoDetalleCampaniaPK;
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

    public TargetEdad getTargetEdad() {
        return targetEdad;
    }

    public void setTargetEdad(TargetEdad targetEdad) {
        this.targetEdad = targetEdad;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getMaximoHora() {
        return maximoHora;
    }

    public void setMaximoHora(String maximoHora) {
        this.maximoHora = maximoHora;
    }

    public String getMinimoHora() {
        return minimoHora;
    }

    public void setMinimoHora(String minimoHora) {
        this.minimoHora = minimoHora;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.segmentoDetalleCampaniaPK);
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
        final SegmentoDetalleCampania other = (SegmentoDetalleCampania) obj;
        if (!Objects.equals(this.segmentoDetalleCampaniaPK, other.segmentoDetalleCampaniaPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SegmentoDetalleCampania{" + "segmentoDetalleCampaniaPK=" + segmentoDetalleCampaniaPK + ", targetEdad=" + targetEdad + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", maximoHora=" + maximoHora + ", minimoHora=" + minimoHora + '}';
    }
    
}
