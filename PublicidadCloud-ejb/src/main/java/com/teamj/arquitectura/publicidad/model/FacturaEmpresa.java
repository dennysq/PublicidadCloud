/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.publicidad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "FACTURA_EMPRESA")
public class FacturaEmpresa implements Serializable{
    @Id
    @SequenceGenerator(name = "FACTURA_EMPRESA_ID", sequenceName = "FACTURA_EMPRESA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "FACTURA_EMPRESA_ID")
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
    
    @Column(name = "PORCENTAJE_IVA")
    private BigDecimal porcentaje;
    
    @Column(name = "SUBTOTAL")
    private BigDecimal subtotal;

    public FacturaEmpresa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(String secuencial) {
        this.secuencial = secuencial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final FacturaEmpresa other = (FacturaEmpresa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FacturaEmpresa{" + "id=" + id + ", empresa=" + empresa + ", fecha_emision=" + fecha_emision + ", secuencial=" + secuencial + ", direccion=" + direccion + ", telefono=" + telefono + ", valor_total=" + valor_total + ", porcentaje=" + porcentaje + ", subtotal=" + subtotal + '}';
    }

}
