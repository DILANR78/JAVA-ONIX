package com.onix.ONIXJ.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.service.ProveedorService;


@Controller

public class rutas {

    @Autowired
private ProveedorService proveedorService;
    @GetMapping("/")
    public String index(){
    return "Indexhomepage";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/indexdashboard")
    public String indexdashboard(ModelMap model){
        model.addAttribute("proveedor", new Proveedor());
        return "indexdashboard";
    }

    @RequestMapping("/productoChaquetaVigilancia")
    public String productoChaquetaVigilancia(ModelMap model){
        model.addAttribute("proveedor", new Proveedor());
        return "productoChaquetaVigilancia";
    }

    @GetMapping("/RegistrarProveedor")
    public String RegistrarProveedor(ModelMap model ){
        model.addAttribute("proveedor", new Proveedor());
        List<Proveedor> proveedores = proveedorService.getProveedor();
        model.addAttribute("proveedor", proveedores);
        return "RegistrarProveedor";
    }
}


    