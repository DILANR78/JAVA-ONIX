package com.onix.ONIXJ.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.onix.ONIXJ.entity.Categoria;
import com.onix.ONIXJ.service.CategoriaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/Categoria")
    public String indexCategoria(ModelMap model){
        List<Categoria> categorias = categoriaService.getCategoria();
        model.addAttribute("categorias", categorias);
        System.out.println("cc"+categorias);
        return "Categoria";
    }

    @GetMapping("/editarcategoria/{idCategoria}")
    public String editarcategoria(@PathVariable Long idCategoria, ModelMap model){
        model.addAttribute("categorias", new Categoria());
        Optional<Categoria> categorias = categoriaService.getCategoriaById(idCategoria);
        model.addAttribute("categorias", categorias.orElse(null));
        System.out.println("SE A CARGADO EL OBJETO: "+categorias);
        return "EditarCate";
    }

    @PostMapping("/editarcategoria/EditarCate")
    public String postMethoEdit(@ModelAttribute("categorias")Categoria categoria){
        categoriaService.saveOrUpdate(categoria);
        System.out.println("Se a editado: "+ categoria);
        return "redirect:/Categoria";
    }
    
    @PostMapping("/agregarcategoria")
    public String guardarCategoria(@ModelAttribute("categorias")Categoria categoria){
        categoriaService.saveOrUpdate(categoria);
        System.out.println("Se Registro: " +categoria);
        return "redirect:/Categoria";
    }

    @GetMapping("/Agregarcate")
    public String Agregarcate(ModelMap model){
        model.addAttribute("categorias", new Categoria());
        return "Agregarcate";
    }
    
    @RequestMapping("/elimarcate/{idCategoria}")
    public String eliminarCategoria(@PathVariable Long idCategoria, ModelMap model){
        categoriaService.deleteCategoria(idCategoria);
        System.out.println("SE A ELIMINADO: "+ idCategoria);
        return "redirect:/Categoria";
    }
    
    
}
