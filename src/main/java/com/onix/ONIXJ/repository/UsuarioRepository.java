package com.onix.ONIXJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onix.ONIXJ.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM onix.usuario WHERE correo_usuario = :correo AND contraseña_usuario = :contraseña", nativeQuery = true)
    Usuario findByCorreoAndContraseña(@Param("correo") String correo, @Param("contraseña") String contraseña);
}
