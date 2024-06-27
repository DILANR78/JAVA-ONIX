// SERVICE DE PROVEEDOR

package com.onix.ONIXJ.service;

// TODAS LAS IMPORTANCIONES NECESARIAS

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.repository.ProveedorRepository;

//HACEMOS LA CREACION DEL SERVICE GRACIAS AL REPOSITORY PARA PODER MANIPULAR ESOS METODOS Y TENERLOS FISICOS Y NO ABSTRACTOS

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public List<Proveedor> getProveedor(){
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> getProveedorById(Long idProveedor){
    return proveedorRepository.findById(idProveedor);
    }

    public void saveOrUpdate(Proveedor proveedor){
        proveedorRepository.save(proveedor);
    }

    public void deleteProveedor(Long idProveedor){
        proveedorRepository.deleteById(idProveedor);
    }

}