//VENTA DETALLE

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
@Table(name= "ventadetalle")
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetalle;

    @Column(name = "cantidadVentaDetalle", nullable = true, columnDefinition = "int(11)")
    private String cantidadVentaDetalle;

    @Column(name = "descripcionVentaDetalle", nullable = true, columnDefinition = "varchar(55)")
    private String descripcionVentaDetalle;

    @Column(name = "valorUnitarioVentaDetalle", nullable = true, columnDefinition = "int(11)")
    private int valorUnitarioVentaDetalle;

    @Column(name = "valorTotalVentaDetalle", nullable = true, columnDefinition = "int(11)")
    private int valorTotalVentaDetalle;

}
