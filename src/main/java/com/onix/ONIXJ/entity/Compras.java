//COMPRAS

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
@Table(name= "compras")
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompra;

    @Column(name = "descripcionCompra", nullable = true, columnDefinition = "varchar(55)")
    private String descripcionCompra;

    @Column(name = "valorToltalCompra", nullable = true, columnDefinition = "int(11)")
    private int valorToltalCompra;

    @Column(name = "fechaCompra", nullable = true, columnDefinition = "date")
    private LocalDate fechaCompra;

    //LLAVES FORANEAS
    @ManyToOne
    @JoinColumn(name = "proveedor_idProveedor", nullable = true)
    private Proveedor proveedor;;
    
}
