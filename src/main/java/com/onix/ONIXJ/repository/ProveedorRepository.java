//REPOSITORY DE PROVEEDOR

package com.onix.ONIXJ.repository;

// TODAS LAS IMPORTANCIONES NECESARIAS

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onix.ONIXJ.entity.Proveedor;

//HACEMOS LA IMPORTANCION DEL ENTITY

@Repository
public interface ProveedorRepository extends JpaRepository <Proveedor, Long>{
}