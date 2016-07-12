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
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL
    @Column(name = "ID_HISTORIAL_CAMPANIA")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "SEC_CAMPANIA")
    private Campania campania;
    
    @Column(name = "FECHA_COMPRA")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_compra;
  
    @Column(name = "CLICS")
    private Integer clics;
    
    @Column(name = "COSTO_CLIC")
    private BigDecimal costo_clic;
    
    @Column(name = "DESPLIEGUES")
    private Integer despligues;
    
    @Column(name = "COSTO_DESPLIEGUE")
    private BigDecimal costo_despligue;

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

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Integer getClics() {
        return clics;
    }

    public void setClics(Integer clics) {
        this.clics = clics;
    }

    public BigDecimal getCosto_clic() {
        return costo_clic;
    }

    public void setCosto_clic(BigDecimal costo_clic) {
        this.costo_clic = costo_clic;
    }

    public Integer getDespligues() {
        return despligues;
    }

    public void setDespligues(Integer despligues) {
        this.despligues = despligues;
    }

    public BigDecimal getCosto_despligue() {
        return costo_despligue;
    }

    public void setCosto_despligue(BigDecimal costo_despligue) {
        this.costo_despligue = costo_despligue;
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
        return "HistorialCampania{" + "id=" + id + ", campania=" + campania + ", fecha_compra=" + fecha_compra + ", clics=" + clics + ", costo_clic=" + costo_clic + ", despligues=" + despligues + ", costo_despligue=" + costo_despligue + '}';
    }

}
