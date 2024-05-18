//PRODUCTO TERMINADO


package com.onix.ONIXJ.entity;

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
@Table(name = "tipoProductoTerminado")
public class TipoProdutoTerminado {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idProductoTerminado;

    @Column(name = "tipoProductoTerminado", nullable = true, columnDefinition = "varchar(55)")
    private String tipoProductoTerminado;

    @Column(name = "colorProductoTerminado", nullable = true, columnDefinition = "varchar(45)")
    private String colorProductoTerminado;

    @Column(name = "materialProductoTerminado", nullable = true, columnDefinition = "varchar(45)")
    private String materialProductoTerminado;

    //LLAVES FORANEAS
    @ManyToOne
    @JoinColumn(name = "categoria_idCategoria", nullable = true)
    private Categoria categoria;
    
}