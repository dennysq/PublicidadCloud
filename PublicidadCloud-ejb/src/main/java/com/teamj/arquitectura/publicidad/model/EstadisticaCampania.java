/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
    
    @Column(name = "CLICS")
    private Integer clics;
    
    @Column(name = "DESPLIEGUES")
    private Integer despligues;
    
}
