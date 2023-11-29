package com.example.demo.Servicio;


import java.util.List;
import com.example.demo.Modelo.Provedores;
public interface IUprovedoresServicio {
    
    List<Provedores> getprovedores();
    Provedores   grabarprovedor(Provedores provedor);
    Provedores  buscarprovedor(Long id);
    Provedores buscarprovedoreditar(Provedores provedor);
    int delete(Long id);
}