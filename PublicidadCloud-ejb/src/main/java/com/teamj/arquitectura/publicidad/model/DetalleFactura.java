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

    public DetalleFactura() {
    }

    public FacturaEmpresa getFacturaEmpresa() {
        return facturaEmpresa;
    }

    public void setFacturaEmpresa(FacturaEmpresa facturaEmpresa) {
        this.facturaEmpresa = facturaEmpresa;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(BigDecimal valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public BigDecimal getValor_descuento() {
        return valor_descuento;
    }

    public void setValor_descuento(BigDecimal valor_descuento) {
        this.valor_descuento = valor_descuento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.facturaEmpresa);
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
        final DetalleFactura other = (DetalleFactura) obj;
        if (!Objects.equals(this.facturaEmpresa, other.facturaEmpresa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "facturaEmpresa=" + facturaEmpresa + ", codigoProducto=" + codigoProducto + ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", valor_unitario=" + valor_unitario + ", valor_total=" + valor_total + ", valor_descuento=" + valor_descuento + '}';
    }

}
