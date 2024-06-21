package com.onix.ONIXJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onix.ONIXJ.entity.Compras;

@Repository
public interface RegistrarCompraRepository extends JpaRepository <Compras, Long>{

}
