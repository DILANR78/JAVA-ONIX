//TABLA DE ROL

package com.onix.ONIXJ.entity;

// TODAS LAS IMPORTANCIONES NECESARIAS// TODAS LAS IMPORTANCIONES NECESARIAS

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// CREACION DE LAS TABLAS PARA LA BD

@Data
@Entity
@Table(name= "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nombreRol", nullable = true, columnDefinition = "varchar(55)")
    private String nombreRol;

}
