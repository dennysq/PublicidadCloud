/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
}
