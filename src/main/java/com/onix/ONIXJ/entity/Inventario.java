//TABLA DE INVENTARIO

package com.onix.ONIXJ.entity;

// TODAS LAS IMPORTANCIONES NECESARIAS

import java.time.LocalDate;
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
@Table(name= "inventario")
public class Inventario{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInventario;

    @Column(name = "tipoInsumo", nullable = true, columnDefinition = "varchar(55)")
    private String tipoInsumo;

    @Column(name = "stockInsumo", nullable = true, columnDefinition = "int(11)")
    private int stockInsumo;

    @Column(name = "precioInsumo", nullable = true, columnDefinition = "int(11)")
    private int precioInsumo;

    @Column(name = "tipoProductoTerminado", nullable = true, columnDefinition = "varchar(55)")
    private String tipoProductoTerminado;
    
    @Column(name = "stockProductoTerminado", nullable = true, columnDefinition = "int(11)")
    private int stockProductoTerminado;

    @Column(name = "tallaProductoTerminado", nullable = true, columnDefinition = "varchar(55)")
    private String tallaProductoTerminado;

    @Column(name = "precioProductoTerminado", nullable = true, columnDefinition = "int(11)")
    private int precioProductoTerminado;

    @Column(name = "fechaIngreso", nullable = true, columnDefinition = "date")
    private LocalDate fechaIngreso;

    @Column(name = "fechaSalida", nullable = true, columnDefinition = "date")
    private LocalDate fechaSalida;

    //LLAVES FORANEAS
    @ManyToOne
    @JoinColumn(name = "categoria_idCategoria", nullable = true)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "proveedor_idProveedor", nullable = true)
    private Proveedor proveedor;
}
