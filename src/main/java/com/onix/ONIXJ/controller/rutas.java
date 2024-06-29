//CONTROLER DE LAS RUTAS

package com.onix.ONIXJ.controller;

// TODAS LAS IMPORTANCIONES NECESARIAS

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.service.ProveedorService;

//CRUD DE LAS RUTAS Y AYUDA A MANEJAR LAS PETICIONES DEL SERVICE

@Controller
public class rutas {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/")
    public String index(){
    return "Indexhomepage";
    }
    
    @GetMapping("/paginainicial")
    public String indexh(){
    return "Indexhomepage";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/Servicios")
    public String Servicios(){
        return "Servicios";
    }

    @RequestMapping("/Productos")
    public String Productos(){
        return "Productos";
    }

    @RequestMapping("/Contactenos")
    public String Contactenos(){
        return "Contactenos";
    }

    @GetMapping("/error404")
    public String Error404(){
        return "Error 404";
    }

    @GetMapping("/error500")
    public String Error500(){
        return "Error 505";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "indexdashboard";
    }
    
    @GetMapping("/dashboard2")
    public String dashboard2(){
        return "indexdashboard2";
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