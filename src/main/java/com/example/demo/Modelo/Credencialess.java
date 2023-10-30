package com.example.demo.Modelo;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "autenticacion")
public class Credencialess {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    
    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Column(name="password", nullable = false, unique = true)
    private String password;

   public Credencialess(){

   }
   
   public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

}