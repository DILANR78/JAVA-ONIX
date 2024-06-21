package com.onix.ONIXJ.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.onix.ONIXJ.entity.Inventario;
import com.onix.ONIXJ.service.InventarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
public class InventarioController {
    
    @Autowired
    private InventarioService inventarioService;

    //CRUD DE INVENTARIO
    @GetMapping("/inventario")
    public String indexInventario(Model model) {
        List<Inventario> inventarios = inventarioService.getInventario();
        model.addAttribute("inventario", inventarios);
        return "RegistrarInventario";
    }
    
    @GetMapping("/editarinventario/{idInventario}")
    public String editarinventario(@PathVariable Long idInventario, ModelMap model){
        model.addAttribute("inventarios", new Inventario());
        Optional<Inventario> inventatrios = inventarioService.getInventarioById(idInventario);
        model.addAttribute("inventario", inventatrios.orElse(null));
        System.out.println("SE A CARGADO EL OBJETO: "+inventatrios);
        return "Editarinven";
    }

    @PostMapping("/editarinventario/Editarinventario")
    public String postMethodEdit(@ModelAttribute("inventario") Inventario inventario) {
        inventarioService.saveOrUpdate(inventario);
        System.out.println("SE A EDITADO: "+inventario.getIdInventario());
        return "redirect:/inventario";
    }
    
    @PostMapping("/agregarinventario")
    public String guardarInventario(ModelMap model) {
        model.addAttribute("inventario", new Inventario());
        return "Agregarinven";
    }

    @RequestMapping("/eliminarinventario/{idInventario}")
    public String eliminarInventario(@PathVariable Long idInventario, ModelMap model) {
        inventarioService.deleteInventario(idInventario);
        System.out.println("SE A ELIMINADO: "+idInventario);
        return "redirect:/inventario";
    }
    
    
}
