package com.onix.ONIXJ.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onix.ONIXJ.entity.Rol;
import com.onix.ONIXJ.repository.RolRepository;

@Service
public class RolService {
    
       @Autowired 
        RolRepository rolRepository;

        public List<Rol> getRol(){
            return rolRepository.findAll();
        }

        public Optional<Rol> getRolById(Long idRol){
            return rolRepository.findById(idRol);
        }

        public void saveOrUpdate(Rol rol){
            rolRepository.save(rol);
        }

        public void deleteRol(Long idRol){
            rolRepository.deleteById(idRol);
        }
        
}
