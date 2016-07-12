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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "DETALLE_FACTURA")
public class DetalleFactura implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_FACTURA")
    private FacturaEmpresa facturaEmpresa;
    
    @Column(name = "CODIGO_PRODUCTO")
    private Integer codigoProducto;
    
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "VALOR_UNITARIO")
    private BigDecimal valor_unitario;
    
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valor_total;
    
    @Column(name = "VALOR_DESCUENTO")
    private BigDecimal valor_descuento;
    
    
    
}
