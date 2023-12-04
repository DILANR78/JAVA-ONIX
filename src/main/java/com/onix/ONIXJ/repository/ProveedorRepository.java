package com.onix.ONIXJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onix.ONIXJ.entity.Proveedor;


@Repository
public interface ProveedorRepository extends JpaRepository <Proveedor, Long>{
}
