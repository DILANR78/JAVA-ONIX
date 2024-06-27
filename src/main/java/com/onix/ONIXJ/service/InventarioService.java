// SERVICE DE INVENTARIO 

package com.onix.ONIXJ.service;

// TODAS LAS IMPORTANCIONES NECESARIAS

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.onix.ONIXJ.entity.Inventario;
import com.onix.ONIXJ.repository.InventarioRepository;

//HACEMOS LA CREACION DEL SERVICE GRACIAS AL REPOSITORY PARA PODER MANIPULAR ESOS METODOS Y TENERLOS FISICOS Y NO ABSTRACTOS

@Service
public class InventarioService {
    
    @Autowired
    InventarioRepository inventarioRepository;

    public List<Inventario> getInventario(){
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> getInventarioById(Long idInventario){
        return inventarioRepository.findById(idInventario);
    }

    public void saveOrUpdate(Inventario inventario){
        inventarioRepository.save(inventario);
    }

    public void deleteInventario(Long idInventario){
        inventarioRepository.deleteById(idInventario);
    }

}
