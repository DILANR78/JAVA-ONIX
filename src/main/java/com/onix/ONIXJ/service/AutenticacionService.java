package com.onix.ONIXJ.service;

import org.springframework.stereotype.Service;

@Service
public class AutenticacionService {

    private boolean isAutenticado = false;

    public boolean isUsuarioAutenticado () {

        return isAutenticado;
    }

    public void setUsuarioAutenticado(boolean isAutenticado){
        this.isAutenticado = isAutenticado;
    }

    private boolean isAutenticadoEmpleado = false;

    public boolean isAutenticadoEmpleado () {

        return isAutenticadoEmpleado;
    }

    public void setAutenticadodoEmpleado(boolean isAutenticadoEmpleado){
        this.isAutenticadoEmpleado = isAutenticadoEmpleado;
    }
    
}
