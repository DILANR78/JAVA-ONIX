//CONTROLER DE LAS RUTAS

package com.onix.ONIXJ.controller;

// TODAS LAS IMPORTANCIONES NECESARIAS

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.onix.ONIXJ.entity.Proveedor;
import com.onix.ONIXJ.entity.Usuario;
import com.onix.ONIXJ.repository.UsuarioRepository;
import com.onix.ONIXJ.service.AutenticacionService;
import com.onix.ONIXJ.service.ProveedorService;


//CRUD DE LAS RUTAS Y AYUDA A MANEJAR LAS PETICIONES DEL SERVICE

@Controller
public class rutas {

    @Autowired
    private ProveedorService proveedorService;
    
    @Autowired
    private AutenticacionService autenticacionService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/")
    public String index(){
    return "Indexhomepage";
    }
    
    @GetMapping("/paginainicial")
    public String indexh(){
    return "Indexhomepage";
    }

    @RequestMapping("/Servicios")
    public String Servicios(){
        return "Servicios";
    }

    @RequestMapping("/Productos")
    public String Productos(){
        return "Productos";
    }

    @RequestMapping("/Contactenos")
    public String Contactenos(){
        return "Contactenos";
    }

    @GetMapping("/error404")
    public String Error404(){
        return "Error 404";
    }

    @GetMapping("/error500")
    public String Error500(){
        return "Error 505";
    }

    @GetMapping("/cerrarsesion")
    public String cerrarsesion() {
        autenticacionService.setAutenticadodoEmpleado(false);
        autenticacionService.setUsuarioAutenticado(false);
        return "redirect:/login";
    }
    

    //LOGEO

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @GetMapping("/validacionUsuario")
public String ingreso(@RequestParam("correoUsuario") String correoUsuario, @RequestParam("contraseñaUsuario") String contraseñaUsuario, Model model) {
    if (correoUsuario != null && contraseñaUsuario != null) {
        Usuario usuario = usuarioRepository.findByCorreoAndContraseña(correoUsuario, contraseñaUsuario);
        if (usuario != null) {
            switch (usuario.getRol().getIdRol()) {
                case 1:
                    model.addAttribute("usuario", usuario);
                    autenticacionService.setUsuarioAutenticado(true);
                    return "redirect:/dashboard";
                case 2:
                    model.addAttribute("usuario", usuario);
                    autenticacionService.setAutenticadodoEmpleado(true);
                    return "redirect:/dashboard2";
                default:
                    break;
            }
        }
    }
    return "redirect:/login";
}
    
    @GetMapping("/dashboard")
        public String dashboard(){

    if(autenticacionService.isUsuarioAutenticado()){
        autenticacionService.setAutenticadodoEmpleado(false);
        return "indexdashboard";
    } else {
        return "redirect:/";
    }

}   

    @GetMapping("/dashboard2")
    public String dashboard2(){
        if(autenticacionService.isAutenticadoEmpleado()){
            autenticacionService.setUsuarioAutenticado(false);
            return "indexdashboard2";
        } else {
            return "redirect:/";
        }
    }


    @RequestMapping("/indexdashboard")
    public String indexdashboard(ModelMap model){
        model.addAttribute("proveedor", new Proveedor());
        return "indexdashboard";
    }

    @RequestMapping("/productoChaquetaVigilancia")
    public String productoChaquetaVigilancia(ModelMap model){
        model.addAttribute("proveedor", new Proveedor());
        return "productoChaquetaVigilancia";
    }

    @GetMapping("/RegistrarProveedor")
    public String RegistrarProveedor(ModelMap model ){
        model.addAttribute("proveedor", new Proveedor());
        List<Proveedor> proveedores = proveedorService.getProveedor();
        model.addAttribute("proveedor", proveedores);
        return "RegistrarProveedor";
    }
}