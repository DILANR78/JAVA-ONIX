package com.onix.ONIXJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onix.ONIXJ.entity.Insumo;

@Repository
public interface InsumosRepository extends JpaRepository <Insumo, Long>{
    
}
