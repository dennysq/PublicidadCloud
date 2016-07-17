/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
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

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "TARGET_EDAD")
public class TargetEdad implements Serializable{
    
    @Id
//    @SequenceGenerator(name = "TARGET_EDAD_ID", sequenceName = "TARGET_EDAD_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TARGET_EDAD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL&&SQL
    @Column(name = "ID_TARGET_EDAD")
    private Integer id;
    
//    @ManyToOne
//    @JoinColumn(name = "RUC")
//    private Empresa empresa;
//    
    @Column(name = "RUC")
    private String ruc;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "EDAD_MINIMA")
    private Integer edadMinima;
    
    @Column(name = "EDAD_MAXIMA")
    private Integer edadMaxima;
    
    @Column(name = "GENERO")
    private String genero;

    public TargetEdad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Empresa getEmpresa() {
//        return empresa;
//    }
//
//    public void setEmpresa(Empresa empresa) {
//        this.empresa = empresa;
//    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public Integer getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(Integer edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final TargetEdad other = (TargetEdad) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "TargetEdad{" + "id=" + id + ", empresa=" + empresa + ", nombre=" + nombre + ", descripcion=" + descripcion + ", edadMinima=" + edadMinima + ", edadMaxima=" + edadMaxima + ", genero=" + genero + '}';
//    }

    @Override
    public String toString() {
        return "TargetEdad{" + "id=" + id + ", ruc=" + ruc + ", nombre=" + nombre + ", descripcion=" + descripcion + ", edadMinima=" + edadMinima + ", edadMaxima=" + edadMaxima + ", genero=" + genero + '}';
    }
    
    
    
}
