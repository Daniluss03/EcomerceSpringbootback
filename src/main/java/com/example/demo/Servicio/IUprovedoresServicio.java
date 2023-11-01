package com.example.demo.Servicio;


import java.util.List;


import com.example.demo.Modelo.Provedores;
public interface IUprovedoresServicio {
    
    List<Provedores> getprovedores();


    Provedores   grabarprovedor(Provedores provedor);
    Provedores  buscarprovedoreditar(Provedores provedor);
 
}
