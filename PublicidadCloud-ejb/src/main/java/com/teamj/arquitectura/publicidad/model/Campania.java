/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.TemporalType;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "CAMPANIA")
public class Campania implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL&&SQL
    @Column(name = "SEC_CAMPANIA")
    private Integer sec;
    
    @ManyToOne
    @JoinColumn(name = "RUC")
    private Empresa empresa;
        
//    @Column(name = "RUC")
//    private String ruc;
//    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "FECHA_CREACION")    
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaCreacion;
    
    @Column(name = "FECHA_INICIO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaInicio;
    
    @Column(name = "FECHA_FIN")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaFin;
    
    @Column(name = "ESTADO")
    private String estado;

    public Campania() {
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getFechaFin() {
        return fechaFin;
    }
   
    public Integer getSec() {
        return sec;
    }

    public void setSec(Integer sec) {
        this.sec = sec;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    

    public Date getFechaInicio() {
        return fechaInicio;
    }
   
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.sec);
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
        final Campania other = (Campania) obj;
        if (!Objects.equals(this.sec, other.sec)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Campania{" + "sec=" + sec + ", Empresa=" + empresa.toString() + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + '}';
    }

       
}
