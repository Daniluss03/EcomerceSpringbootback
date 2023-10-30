package com.example.demo.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = Provedores.TABLE_NAME)
public class Provedores {

    public static final String TABLE_NAME = "provedor";
   
   
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprovedor") // Esto es una anotación @Column para el atributo idprovedor
    private int idprovedor;
    @Column(name = "Ciudad")
    private String Ciudad;
    @Column(name = "Direccion")
    private String Direccion;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Telefono")
    private String Telefono;
    @Column(name = "Nit")
    private String Nitt;

    public Provedores() {
        // Constructor vacío requerido por JPA
    }

    public int getIdprovedor() {
        return idprovedor;
    }

    public void setIdprovedor(int idprovedor) {
        this.idprovedor = idprovedor;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getNitt() {
        return Nitt;
    }

    public void setNitt(String Nitt) {
        this.Nitt = Nitt;
    }

    @Override
    public String toString() {
        return "idprovedor" + idprovedor + "Nombre" + Nombre + "Telefono" + Telefono;
    }
}
