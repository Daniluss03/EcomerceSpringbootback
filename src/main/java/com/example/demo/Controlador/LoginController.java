package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Modelo.Credencialess;
import com.example.demo.Servicio.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin("*")
@RequestMapping("/log")

public class LoginController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

   
    @PostMapping("/loginautentication")
    public ResponseEntity<String> login(@RequestBody Credencialess credenciales) {
        String username = credenciales.getUsername();
        String password = credenciales.getPassword();

        if (usuarioService.autenticar(username, password)) {
            return ResponseEntity.ok("Autenticación exitosa");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
