//REPOSITORY DE ROL

package com.onix.ONIXJ.repository;

// TODAS LAS IMPORTANCIONES NECESARIAS

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onix.ONIXJ.entity.Rol;

//HACEMOS LA IMPORTANCION DEL ENTITY

@Repository
public interface RolRepository extends JpaRepository <Rol, Long>{
}