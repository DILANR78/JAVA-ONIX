//TABLA DE CATEGORIA

package com.onix.ONIXJ.entity;

// TODAS LAS IMPORTANCIONES NECESARIAS

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
@Table(name= "categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategoria;

    @Column(name = "tipoCategoria", nullable = true, columnDefinition = "varchar(45)")
    private String tipoCategoria;
    
}