//REPOSITORY DE CATEGORIA

package com.onix.ONIXJ.repository;

// TODAS LAS IMPORTANCIONES NECESARIAS

import com.onix.ONIXJ.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

//HACEMOS LA IMPORTANCION DEL ENTITY

public interface CategoriaReposirory extends JpaRepository <Categoria, Long>{
}