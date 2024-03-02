package com.onix.ONIXJ.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.repository.ProveedorRepository;

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