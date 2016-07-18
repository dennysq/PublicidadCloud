/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "HISTORIAL_CAMPANIA")
public class HistorialCampania implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL&&SQL
    @Column(name = "ID_HISTORIAL_CAMPANIA")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "SEC_CAMPANIA")
    private Campania campania;
    
    @Column(name = "FECHA_COMPRA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaCompra;
  
    @Column(name = "CLICS")
    private Integer clics;
    
    @Column(name = "COSTO_CLIC")
    private BigDecimal costoClic;
    
    @Column(name = "DESPLIEGUES")
    private Integer despligues;
    
    @Column(name = "COSTO_DESPLIEGUE")
    private BigDecimal costoDespligue;

    public HistorialCampania() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Campania getCampania() {
        return campania;
    }

    public void setCampania(Campania campania) {
        this.campania = campania;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getClics() {
        return clics;
    }

    public void setClics(Integer clics) {
        this.clics = clics;
    }

    public BigDecimal getCostoClic() {
        return costoClic;
    }

    public void setCostoClic(BigDecimal costoClic) {
        this.costoClic = costoClic;
    }

    public Integer getDespligues() {
        return despligues;
    }

    public void setDespligues(Integer despligues) {
        this.despligues = despligues;
    }

    public BigDecimal getCostoDespligue() {
        return costoDespligue;
    }

    public void setCostoDespligue(BigDecimal costoDespligue) {
        this.costoDespligue = costoDespligue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final HistorialCampania other = (HistorialCampania) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HistorialCampania{" + "id=" + id + ", campania=" + campania + ", fechaCompra=" + fechaCompra + ", clics=" + clics + ", costoClic=" + costoClic + ", despligues=" + despligues + ", costoDespligue=" + costoDespligue + '}';
    }
}
