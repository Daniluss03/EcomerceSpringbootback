package com.example.demo.Servicio;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.LoginRepo;

import jakarta.transaction.Transactional;

import com.example.demo.Modelo.Credencialess;

@Service
@Transactional

public class UsuarioService {
    @Autowired
    private LoginRepo credencialesRepository;

    public boolean autenticar(String username, String password) {
        Credencialess credenciales = credencialesRepository.findByUsername(username);
        return credenciales != null && credenciales.getPassword().equals(password);
    }
}

  
