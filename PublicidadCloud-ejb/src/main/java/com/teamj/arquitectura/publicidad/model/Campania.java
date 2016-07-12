/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "CAMPANIA")
public class Campania implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL
    @Column(name = "SEC_CAMPANIA")
    private Integer sec;
    
    @ManyToOne
    @JoinColumn(name = "RUC")
    private Empresa empresa;
        
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "FECHA_CREACION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_creacion;
    
    @Column(name = "FECHA_INICIO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_inicio;
    
    @Column(name = "FECHA_FIN")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_fin;
    
    @Column(name = "ESTADO")
    private String estado;
    
}
