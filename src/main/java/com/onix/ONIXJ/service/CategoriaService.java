// SERVICE DE CATEGORIA

package com.onix.ONIXJ.service;

// TODAS LAS IMPORTANCIONES NECESARIAS

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onix.ONIXJ.entity.Categoria;
import com.onix.ONIXJ.repository.CategoriaReposirory;

//HACEMOS LA CREACION DEL SERVICE GRACIAS AL REPOSITORY PARA PODER MANIPULAR ESOS METODOS Y TENERLOS FISICOS Y NO ABSTRACTOS

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
