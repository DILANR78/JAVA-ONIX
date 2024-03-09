package com.onix.ONIXJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onix.ONIXJ.entity.Rol;


@Repository
public interface RolRepository extends JpaRepository <Rol, Long>{
    
}
