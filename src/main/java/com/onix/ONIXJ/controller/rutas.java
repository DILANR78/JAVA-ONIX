package com.onix.ONIXJ.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.service.ProveedorService;

import ch.qos.logback.core.model.Model;


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

    @GetMapping("/Agregarprove")
    public String Agregarprove(ModelMap model){
    model.addAttribute("proveedor", new Proveedor());
    return "Agregarprove";
    }

    @RequestMapping("/proveedores/eliminar/{idProveedor}")
    public String EliminarProveedor(@PathVariable Long idProveedor){
        proveedorService.delete(idProveedor);
        System.out.println("SE DEBIO ELIMINO "+idProveedor);
        return "RegistrarProveedor";
    }


    /*
    @RequestMapping("/Editarprove/{idProveedor}")
    public String Editarprove(@PathVariable Long idProveedor, Model model){
        Optional<Proveedor>proveedor=proveedorService.getProveedor(idProveedor);
        System.out.println("Se cargó correctamente = " + proveedor);
        model.addAttribute("proveedor", proveedor.orElse(null));
        return "Editarprove";
        
    }

    @PostMapping("/editar/Editarprove")
    public String actulizarVivienda(@ModelAttribute("vivienda")Proveedor proveedor){
        proveedorService.saveOrUpdate(proveedor);
        System.out.println("Se registro correctamente" + proveedor);
        return "check";
    }
    */

}
    