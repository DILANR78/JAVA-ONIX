package com.onix.ONIXJ.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onix.ONIXJ.entity.Categoria;
import com.onix.ONIXJ.repository.CategoriaReposirory;

@Service
public class CategoriaService {
    
    @Autowired
    CategoriaReposirory categoriaReposirory;

    public List<Categoria> getCategoria(){
        return categoriaReposirory.findAll();
    }

    public Optional<Categoria> getCategoriaById(Long idCategoria){
        return categoriaReposirory.findById(idCategoria);
    }

    public void saveOrUpdate(Categoria categoria){
        categoriaReposirory.save(categoria);
    }

    public void deleteCategoria(Long idCategoria){
        categoriaReposirory.deleteById(idCategoria);
    }

}
