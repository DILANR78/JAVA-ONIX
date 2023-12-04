package com.onix.ONIXJ.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.service.ProveedorService;



@RestController
@RequestMapping(path = "api/v1/Proveedor")
public class ProveedorController {
    

    @Autowired
    private  ProveedorService proveedorService;


    @GetMapping
    public List<Proveedor> getAll(){
        return proveedorService.getProveedor();
    }

        
    @GetMapping("/{proveedorId}")
    public Optional<Proveedor> getBId(@PathVariable("proveedorId")Long proveedorId){
        return proveedorService.getProveedor(proveedorId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Proveedor proveedor){
        proveedorService.saveOrUpdate(proveedor);
    }

    @DeleteMapping("/{proveedorId}")
    public void saveUpdate(@PathVariable("proveedorId")Long proveedorId){
        proveedorService.delete(proveedorId);
    }
}
