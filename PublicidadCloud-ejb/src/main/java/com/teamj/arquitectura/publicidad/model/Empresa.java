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
import javax.persistence.Table;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL
    @Column(name = "RUC")
    private Integer ruc;
    
    @Column(name = "RAZON_SOCIAL")
    private String nombre;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "TELEFONO")
    private String telefono;
    
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Column(name = "REPRESENTANTE")
    private String representante;
}
