//CATEGORIA//

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
@Table(name= "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategoria;

    @Column(name = "tipoInsumo", nullable = true, columnDefinition = "varchar(55)")
    private String tipoInsumo;

    @Column(name = "materialInsumo", nullable = true, columnDefinition = "varchar(55)")
    private String materialInsumo;

    @Column(name = "colorInsumo", nullable = true, columnDefinition = "varchar(55)")
    private String colorInsumo;

    @Column(name = "tipoProductoTerminado", nullable = true, columnDefinition = "varchar(55)")
    private String tipoProductoTerminado;

    @Column(name = "colorProductoTerminado", nullable = true, columnDefinition = "varchar(45)")
    private String colorProductoTerminado;

    @Column(name = "materialProductoTerminado", nullable = true, columnDefinition = "varchar(45)")
    private String materialProductoTerminado;
    
}