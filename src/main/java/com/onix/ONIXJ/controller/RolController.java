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

import com.onix.ONIXJ.entity.Rol;
import com.onix.ONIXJ.service.RolService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RolController {
    
    @Autowired
    private RolService rolService;

    @GetMapping("/rol")
    public String indexRol(Model model){
        List<Rol> roles = rolService.getRol();
        model.addAttribute("roles", roles);
        System.out.println("rr"+roles);
        return "Roles";
    }

    @GetMapping("/editarrol/{idRol}")
    public String editarrol(@PathVariable Long idRol, ModelMap model){
    model.addAttribute("roles", new Rol());
    Optional<Rol> roles = rolService.getRolById(idRol);
    model.addAttribute("rol" , roles.orElse(null));
    System.out.println("SE A CARGADO EL OBJETO: "+ roles);
    return "EditarRol";
    }

    @PostMapping("/editarrol/EditarRol")
    public String postMethoEdit(@ModelAttribute("roles") Rol rol){
    rolService.saveOrUpdate(rol);
    System.out.println("Se a editado: "+ rol);
    return "redirect:/rol";
    }

    @PostMapping("/agregarrol")
    public String guardarRol(@ModelAttribute("roles")Rol rol){
    rolService.saveOrUpdate(rol);
    System.out.println("Se Registro: " +rol);
    return "redirect:/rol";
    }

    @GetMapping("/Agregarrol")
    public String Agregarrol(ModelMap model){
    model.addAttribute("rol", new Rol());
    return "AgregarRol";
    }

    @RequestMapping("/eliminarrol/{idRol}")
    public String eliminarRol(@PathVariable Long idRol, ModelMap model){
    rolService.deleteRol(idRol);
    System.out.println("SE A ELIMININADO: "+ idRol);
    return "redirect:/rol";
    }

}

    


