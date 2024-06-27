// SERVICE DE REGISTRAR COMPRA

package com.onix.ONIXJ.service;

// TODAS LAS IMPORTANCIONES NECESARIAS

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onix.ONIXJ.entity.Compras;
import com.onix.ONIXJ.repository.RegistrarCompraRepository;

//HACEMOS LA CREACION DEL SERVICE GRACIAS AL REPOSITORY PARA PODER MANIPULAR ESOS METODOS Y TENERLOS FISICOS Y NO ABSTRACTOS

@Service
public class RegistrarCompraService {
    
    @Autowired
    RegistrarCompraRepository registrarCompraRepository;

    public List<Compras> getCompras(){
        return registrarCompraRepository.findAll();
    }

    public Optional<Compras> getComprasById(Long idCompra){
    return registrarCompraRepository.findById(idCompra);
    }

    public void saveOrUpdate(Compras compras){
        registrarCompraRepository.save(compras);
    }

    public void deleteCompras(Long idCompra){
        registrarCompraRepository.deleteById(idCompra);
    }


}
