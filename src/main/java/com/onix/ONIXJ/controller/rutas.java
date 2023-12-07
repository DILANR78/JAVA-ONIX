package com.onix.ONIXJ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
    public String indexdashboard(){
        return "indexdashboard";
    }

    @RequestMapping("/RegistrarProveedor")
    public String RegistrarProveedor(){
        return "RegistrarProveedor";
    }
}



