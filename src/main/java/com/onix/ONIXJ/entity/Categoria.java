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

    @Column(name = "tipoCategoria", nullable = true, columnDefinition = "varchar(45)")
    private String tipoCategoria;
    
}