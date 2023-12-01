//VENTA

package com.onix.ONIXJ.entity;

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


@Data
@Entity
@Table(name= "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVenta;

    @Column(name = "nombreCliente", nullable = true, columnDefinition = "varchar(55)")
    private String nombreCliente;

    @Column(name = "apellidoCliente", nullable = true, columnDefinition = "varchar(55)")
    private String apellidoCliente;

    @Column(name = "tipoDocumento", nullable = true, columnDefinition = "enum('C.C','NIT')")
    private String tipoDocumento;

    @Column(name = "numeroDocumento", nullable = true, columnDefinition = "int(11)")
    private int numeroDocumento;

    @Column(name = "telefonoCliente", nullable = true, columnDefinition = "int(11)")
    private int telefonoCliente;

    @Column(name = "fechaVenta", nullable = true, columnDefinition = "date")
    private LocalDate fechaVenta;
   

    //LLAVES FORANEAS
    @ManyToOne
    @JoinColumn(name = "usuario_idUsuario", nullable = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ventadetalle_idDetalle", nullable = true)
    private VentaDetalle ventaDetalle;

    @ManyToOne
    @JoinColumn(name = "inventario_idInventario", nullable = true)
    private Inventario inventario;
}