package com.example.demo.Repository;

import com.example.demo.Modelo.Credencialess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Credencialess, String> {
    Credencialess findByUsername(String Nombre);


}
