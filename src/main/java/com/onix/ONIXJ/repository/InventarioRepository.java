package com.onix.ONIXJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onix.ONIXJ.entity.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository <Inventario, Long>{

    
}
