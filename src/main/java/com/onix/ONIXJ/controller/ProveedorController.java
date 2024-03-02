package com.onix.ONIXJ.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.service.ProveedorService;



@Controller
public class ProveedorController {
@Autowired
private ProveedorService proveedorService;

    //CRUD DE PROVEEDORES
    @GetMapping("/proveedores")
    public String indexProveedores(Model model){
        List<Proveedor> proveedores = proveedorService.getProveedor();
        model.addAttribute("proveedor", proveedores);
        System.out.println("pp"+proveedores);
        return "RegistrarProveedor";
    }

    @GetMapping("/editarproveedor/{idProveedor}")
    public String editarproveedor(@PathVariable Long idProveedor, ModelMap model){
        model.addAttribute("proveedor", new Proveedor()); //ENTITY
        Optional<Proveedor> proveedores = proveedorService.getProveedorById(idProveedor);
        model.addAttribute("proveedor", proveedores.orElse(null));
        System.out.println("SE A CARGADO EL OBJETO: "+ proveedores);
        return "Editarprove";
    }

    @PostMapping("/editarproveedor/EditProveedor")
    public String postMethodEdit(@ModelAttribute("proveedor")Proveedor proveedor){
        proveedorService.saveOrUpdate(proveedor);
        System.out.println("SE A EDITADO: "+proveedor.toString());
        return "redirect:/proveedor";
    }

    @PostMapping("/agregarproveedor")
    public String guardarProveedor(@ModelAttribute("proveedor")Proveedor proveedor){
        proveedorService.saveOrUpdate(proveedor);
        System.out.println("SE A REGISTRADO: "+proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/Agregarproveedor")
    public String Agregarproveedor(ModelMap model){
        model.addAttribute("proveedor", new Proveedor());
        return "Agregarprove";
    }

    @RequestMapping("/eliminarproveedor/{idProveedor}")
    public String eliminarProveedor(@PathVariable Long idProveedor, ModelMap model){
        proveedorService.deleteProveedor(idProveedor);
        System.out.println("SE A ELIMINADO: "+idProveedor);
        return "RegistrarProveedor";
    }


}
