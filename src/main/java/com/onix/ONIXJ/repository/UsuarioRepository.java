//REPOSITORY DE USUARIO

package com.onix.ONIXJ.repository;

// TODAS LAS IMPORTANCIONES NECESARIAS

import org.springframework.data.jpa.repository.JpaRepository;
import com.onix.ONIXJ.entity.Usuario;

//HACEMOS LA IMPORTANCION DEL ENTITY

public interface UsuarioRepository extends JpaRepository <Usuario,Long>{
}