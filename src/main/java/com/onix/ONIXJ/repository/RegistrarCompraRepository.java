//REPOSITORY DE REGISTRAR COMPRA

package com.onix.ONIXJ.repository;

// TODAS LAS IMPORTANCIONES NECESARIAS

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onix.ONIXJ.entity.Compras;

//HACEMOS LA IMPORTANCION DEL ENTITY

@Repository
public interface RegistrarCompraRepository extends JpaRepository <Compras, Long>{
}