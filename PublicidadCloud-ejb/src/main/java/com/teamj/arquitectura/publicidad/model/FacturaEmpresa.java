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
@Table(name = "FACTURA_EMPRESA")
public class FacturaEmpresa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL
    @Column(name = "ID_FACTURA")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "RUC")
    private Empresa empresa;
    
    @Column(name = "FECHA_EMISION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha_emision;
    
    @Column(name = "SECUENCIAL")
    private String secuencial;
   
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Column(name = "TELEFONO")
    private String telefono;
    
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valor_total;
    
    @Column(name = "PORCENTAJE")
    private BigDecimal porcentaje;
    
    @Column(name = "SUBTOTAL")
    private BigDecimal subtotal;
}
