//REPOSITORY DE INVENTARIO

package com.onix.ONIXJ.repository;

// TODAS LAS IMPORTANCIONES NECESARIAS

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onix.ONIXJ.entity.Inventario;

//HACEMOS LA IMPORTANCION DEL ENTITY

@Repository
public interface InventarioRepository extends JpaRepository <Inventario, Long>{ 
}