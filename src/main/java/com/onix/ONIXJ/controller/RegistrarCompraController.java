//CONTROLER DE REGISTRAR COMPRA

package com.onix.ONIXJ.controller;

// TODAS LAS IMPORTANCIONES NECESARIAS

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import com.onix.ONIXJ.entity.Compras;
import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.service.RegistrarCompraService;
import com.onix.ONIXJ.service.ProveedorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//CRUD DE REGISTRAR COMPRA Y AYUDA A MANEJAR LAS PETICIONES DEL SERVICE

@Controller
public class RegistrarCompraController {
@Autowired
 RegistrarCompraService registrarCompraService;

@Autowired
ProveedorService proveedorService;

    //CRUD DE REGISTRAR COMPRAS
    @GetMapping("/compras")
    public String indexCompras(Model model) {
        List<Compras> compras = registrarCompraService.getCompras();
        model.addAttribute("compra", compras);
        System.out.println("cc"+compras);
        return  "Compra";
    }
    
    @GetMapping("/editarcompra/{idCompra}")
    public String editarcompras(@PathVariable Long idCompra, ModelMap model){
        model.addAttribute("compras", new Compras());
        Optional<Compras> compras = registrarCompraService.getComprasById(idCompra);
        model.addAttribute("compras", compras.orElse(null));
        List<Proveedor> proveedores = proveedorService.getProveedor();
        model.addAttribute("proveedores", proveedores);
        System.out.println("SE A CARGADO EL OBJETO: "+ compras);
        return "Editarcompra";
    }   

    @PostMapping("/editarcompra/Editarcompra")
    public String postMethodEdit(@ModelAttribute("compra") Compras compra) {
        registrarCompraService.saveOrUpdate(compra);
        System.out.println("SE A EDITADO: " + compra.getIdCompra());
        return "redirect:/compras";
    }
    
    @PostMapping("/agregarcompras")
    public String guardarCompra(@ModelAttribute("compra")Compras compra) {
        registrarCompraService.saveOrUpdate(compra);
        System.out.println("SE A REGISTRADO: "+compra);
        return "redirect:/compras";
    }
    
    @GetMapping("/Agregarcompra")
    public String Agregarcompra(ModelMap model){
        model.addAttribute("compra", new Compras());
        List<Proveedor> proveedores = proveedorService.getProveedor();
        model.addAttribute("proveedor", proveedores);
        return "Agregarcompra";
    }

    @RequestMapping("/eliminarcompra/{idCompra}")
    public String eliminarCompra(@PathVariable Long idCompra, ModelMap model) {
        registrarCompraService.deleteCompras(idCompra);
        System.out.println("SE A ELIMINADO: "+idCompra);
        return "redirect:/compras";
    }
    
    
}