package com.onix.ONIXJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.service.ProveedorService;


@Controller
public class rutas {
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

    @GetMapping("/RegistrarProveedor")
    public String RegistrarProveedor(ModelMap model ){
        List<Proveedor>proveedores=proveedorService.getProveedor();
        model.addAttribute("proveedores" , proveedores);
        model.addAttribute("proveedor", new Proveedor());
        System.out.println("SE CARGO "+ proveedores);
        return "RegistrarProveedor";
    }

    @Autowired
    private  ProveedorService proveedorService;

    @PostMapping("/agregarprove")
    public String guardarProveedor(@ModelAttribute("proveedor")Proveedor proveedor){
        proveedorService.saveOrUpdate(proveedor);
        System.out.println("SE REGISTRO"+proveedor);
        return "RegistrarProveedor";
    }

    @GetMapping("/Editarprove")
    public String Editarprove(){
        return "Editarprove";
    }

    @GetMapping("/Agregarprove")
    public String Agregarprove(ModelMap model){
    model.addAttribute("proveedor", new Proveedor());
    return "Agregarprove";
    }

    @DeleteMapping("/proveedores/eliminar/{idProveedor}")
    public String EliminarProveedor(@RequestParam Long idProveedor){
        proveedorService.delete(idProveedor);
        System.out.println("SE DEBIO ELIMINO "+idProveedor);
        return "RegistrarProveedor";
    }
}
