//CONTROLER DE INVENTARIO

package com.onix.ONIXJ.controller;

// TODAS LAS IMPORTANCIONES NECESARIAS

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import com.onix.ONIXJ.entity.Categoria;
import com.onix.ONIXJ.entity.Inventario;
import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.service.CategoriaService;
import com.onix.ONIXJ.service.InventarioService;
import com.onix.ONIXJ.service.ProveedorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//CRUD DE INVENTARIO Y AYUDA A MANEJAR LAS PETICIONES DEL SERVICE

@Controller
public class InventarioController {
    
    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProveedorService proveedorService;

    //CRUD DE INVENTARIO
    @GetMapping("/inventarios")
    public String indexInventario(Model model) {
        List<Inventario> inventarios = inventarioService.getInventario();
        model.addAttribute("inventarios", inventarios);
        return "Inventario";
    }
    
    @GetMapping("/editarinventario/{idInventario}")
    public String editarinventario(@PathVariable Long idInventario, ModelMap model){
        model.addAttribute("inventarios", new Inventario());
        Optional<Inventario> inventarios=inventarioService.getInventarioById(idInventario);
        model.addAttribute("inventarios", inventarios.orElse(null));
        List<Categoria> categorias = categoriaService.getCategoria();
        model.addAttribute("categorias", categorias);
        System.out.println("SE A CARGADO EL OBJETO: "+inventarios);
        return "Editarinven";
    }

    @PostMapping("/editarinventario/Editarinventario")
    public String postMethodEdit(@ModelAttribute("inventario") Inventario inventario, ModelMap model) {
        inventarioService.saveOrUpdate(inventario);
        System.out.println("SE A EDITADO: "+inventario.getIdInventario());
        return "redirect:/inventarios";
    }
    
    @PostMapping("/agregarinventario")
    public String guardarInventario(@ModelAttribute("inventario")Inventario inventario) {
        inventarioService.saveOrUpdate(inventario);
        System.out.println("SE A REGISTRADO: "+inventario);
        return "redirect:/inventarios";
    }

    @GetMapping("/Agregarinventario")
    public String Agregarinventario(ModelMap model) {
        model.addAttribute("inventarios", new Inventario());
        List<Categoria> categorias = categoriaService.getCategoria();
        model.addAttribute("categorias", categorias);
        List<Proveedor> proveedores = proveedorService.getProveedor();
        model.addAttribute("proveedor", proveedores);
        return "Agregarinventario";
    }
    

    @RequestMapping("/eliminarinventario/{idInventario}")
    public String eliminarInventario(@PathVariable Long idInventario, ModelMap model) {
        inventarioService.deleteInventario(idInventario);
        System.out.println("SE A ELIMINADO: "+idInventario);
        return "redirect:/inventarios";
    }
    
    
}