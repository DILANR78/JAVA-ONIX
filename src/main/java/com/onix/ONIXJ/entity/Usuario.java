//TABLA DE USUARIO

package com.onix.ONIXJ.entity;

// TODAS LAS IMPORTANCIONES NECESARIAS

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

// CREACION DE LAS TABLAS PARA LA BD

@Data
@Entity
@Table(name= "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @Column(name = "nombreUsuario", nullable = true, columnDefinition = "varchar(55)")
    private String nombreUsuario;

    @Column(name = "apellidoUsuario", nullable = true, columnDefinition = "varchar(55)")
    private String apellidoUsuario;

    @Column(name = "correoUsuario", nullable = true, columnDefinition = "varchar(55)")
    private String correoUsuario;

    @Column(name = "contraseñaUsuario", nullable = true, columnDefinition = "varchar(55)")
    private String contraseñaUsuario;

    //LLAVES FORANEAS
    @ManyToOne
    @JoinColumn(name = "rol_idRol", nullable = true)
    private Rol rol;
    
}