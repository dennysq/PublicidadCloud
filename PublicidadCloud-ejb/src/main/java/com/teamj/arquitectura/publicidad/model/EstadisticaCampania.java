/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "ESTADISTICA_CAMPANIA")
public class EstadisticaCampania implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "SEC_CAMPANIA")
    private Campania campania;
    
    @Column(name = "DESPLIEGUES")
    private Integer despligues;
    
    @Column(name = "CLICS")
    private Integer clics;
    
    public EstadisticaCampania() {
    }

    public Campania getCampania() {
        return campania;
    }

    public void setCampania(Campania campania) {
        this.campania = campania;
    }

    public Integer getClics() {
        return clics;
    }

    public void setClics(Integer clics) {
        this.clics = clics;
    }

    public Integer getDespligues() {
        return despligues;
    }

    public void setDespligues(Integer despligues) {
        this.despligues = despligues;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.campania);
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
        final EstadisticaCampania other = (EstadisticaCampania) obj;
        if (!Objects.equals(this.campania, other.campania)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EstadisticaCampania{" + "campania=" + campania + ", clics=" + clics + ", despligues=" + despligues + '}';
    }

}
