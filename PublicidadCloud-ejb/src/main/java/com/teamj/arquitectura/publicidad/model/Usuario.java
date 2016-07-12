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
 * @author Dennys
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL
    @Column(name = "ID_USUARIO")
    private Integer id;
    
    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "NOMBRES")
    private String nombres;
    
    
    
}
