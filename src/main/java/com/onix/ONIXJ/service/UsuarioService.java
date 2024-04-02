package com.onix.ONIXJ.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onix.ONIXJ.entity.Usuario;
import com.onix.ONIXJ.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    public List<Usuario> getUsuario(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long idUsuario){
        return usuarioRepository.findById(idUsuario);
    }

    public void saveOrUpdate(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

}
