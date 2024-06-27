//REPOSITORY DE INSUMOS

package com.onix.ONIXJ.repository;

// TODAS LAS IMPORTANCIONES NECESARIAS

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onix.ONIXJ.entity.Insumo;

//HACEMOS LA IMPORTANCION DEL ENTITY

@Repository
public interface InsumosRepository extends JpaRepository <Insumo, Long>{  
}