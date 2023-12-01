//PROVEEDOR

package com.onix.ONIXJ.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name= "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProveedor;

    @Column(name = "nombreProveedor", nullable = true, columnDefinition = "varchar(55)")
    private String nombreProveedor;

    @Column(name = "tipoDocumentoProveedor", nullable = true, columnDefinition = "enum('C.C','NIT')")
    private String apellidoUsuario;

    @Column(name = "numeroDocumento", nullable = true, columnDefinition = "int(11)")
    private int numeroDocumento;

}