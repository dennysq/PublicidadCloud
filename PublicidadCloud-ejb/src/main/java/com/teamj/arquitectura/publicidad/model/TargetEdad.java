/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
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
@Table(name = "TARGET_EDAD")
public class TargetEdad implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL
    @Column(name = "ID_TARGET_EDAD")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "RUC")
    private Empresa empresa;
    
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
    
}
