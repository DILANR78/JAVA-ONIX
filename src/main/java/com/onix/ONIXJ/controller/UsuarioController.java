package com.onix.ONIXJ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


import com.onix.ONIXJ.entity.Rol;
import com.onix.ONIXJ.entity.Usuario;
import com.onix.ONIXJ.service.RolService;
import com.onix.ONIXJ.service.UsuarioService;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;


    @GetMapping("/usuario")
    public String indexUsuario(Model model){
        List<Usuario> usuarios = usuarioService.getUsuario();
        model.addAttribute("usuarios", usuarios);
        System.out.println("uu"+usuarios);
        return "Usuarios";
    }

    @GetMapping("/editarusuario/{idUsuario}")
    public String editarusuario(@PathVariable Long idUsuario, ModelMap model){
        model.addAttribute("usuarios", new Usuario());
        Optional<Usuario> usuarios=usuarioService.getUsuarioById(idUsuario);
        model.addAttribute("usuarios", usuarios.orElse(null));
        List<Rol> roles = rolService.getRol();
        model.addAttribute("roles", roles);
        System.out.println("SE A CARGADO EL OBJETO: "+ usuarios);
        return "EditarUsuario";
    }
    
    @PostMapping("editarusuario/EditarUsuario")
    public String postMethoEdit(@ModelAttribute("usuarios")Usuario usuario, Model model){
        model.addAttribute("usuarios", new Usuario());
        usuarioService.saveOrUpdate(usuario);
        System.out.println("Se a editado: "+ usuario);
        return "redirect:/usuario";
    }

    @PostMapping("/agregarusuario")
    public String guardarUsuario(@ModelAttribute("usuarios")Usuario usuario){
        usuarioService.saveOrUpdate(usuario);
        System.out.println("Se Registro: "+ usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/Agregarusuario")
    public String Agregarusuario(ModelMap model){
        model.addAttribute("usuario", new Usuario());
        List<Rol> roles = rolService.getRol();
        model.addAttribute("roles", roles);
        return "AgregarUsuario";
    }

    @RequestMapping("/eliminarusuario/{idUsuario}")
    public String eliminarusuario(@PathVariable Long idUsuario,ModelMap model){
        usuarioService.deleteUsuario(idUsuario);
        System.out.println("SE A ELIMININADO: "+ idUsuario);
        return "redirect:/usuario";
    }
    
    

}
