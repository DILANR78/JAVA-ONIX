//INSUMO

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
@Table(name = "insumo")
public class Insumo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idInsumo;

    @Column(name = "colorInsumo", nullable = true, columnDefinition = "varchar(55)")
    private String colorInsumo;

    @Column(name = "materialInsumo", nullable = true, columnDefinition = "varchar(55)")
    private String materialInsumo;

    //LLAVES FORANEAS
    @ManyToOne
    @JoinColumn(name = "categoria_idCategoria", nullable = true)
    private Categoria categoria;
}
