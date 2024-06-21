package com.onix.ONIXJ.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.onix.ONIXJ.entity.Compras;
import com.onix.ONIXJ.service.RegistrarCompraService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






@Controller
public class RegistrarCompraController {
@Autowired
private RegistrarCompraService registrarCompraService;

    //CRUD DE REGISTRAR COMPRAS
    @GetMapping("/compras")
    public String indexCompras(Model model) {
        List<Compras> compras = registrarCompraService.getCompras();
        model.addAttribute("compra", compras);
        System.out.println("cc"+compras);
        return  "-";
    }
    
    @GetMapping("/editarcompras/{idCompra}")
    public String editarcompras(@PathVariable Long idCompras, ModelMap model){
        model.addAttribute("compras", new Compras());
        Optional<Compras> compras = registrarCompraService.getComprasById(idCompras);
        model.addAttribute("compra", compras.orElse(null));
        System.out.println("SE A CARGADO EL OBJETO: "+ compras);
        return "Editarcompra";
    }   

    @PostMapping("/editarcompras/{idCompra}")
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
        model.addAttribute("compra", new Compras())
    }

    @RequestMapping("/eliminarcompra/{idCompra}")
    public String eliminarCompra(@PathVariable Long idCompras, ModelMap model) {
        registrarCompraService.deleteCompras(idCompras);
        System.out.println("SE A ELIMINADO: "+idCompras);
        return "redirect:/compras";
    }
    
    
}