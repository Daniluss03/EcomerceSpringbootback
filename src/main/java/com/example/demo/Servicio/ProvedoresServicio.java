package com.example.demo.Servicio;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Modelo.Provedores;
import com.example.demo.Repository.ProvedorRepo;

@Service
@Transactional

public class ProvedoresServicio implements IUprovedoresServicio {
    

@Autowired
private ProvedorRepo provedorRepo;
   
    @Override
    public List<Provedores> getprovedores(){
        return provedorRepo.findAll();
    };
 
    @Override
    public Provedores grabarprovedor(Provedores provedor){
        return provedorRepo.save(provedor);
    };
    @Override
    public Provedores buscarprovedoreditar(Provedores provedor) {
      return provedorRepo.save(provedor);
    }
    public Provedores getProveedorById(Long id) {
        Optional<Provedores> optionalProveedor = provedorRepo.findById(id);
        return optionalProveedor.orElse(null);
    }

    public void deleteProveedor(Long id) {
         provedorRepo.deleteById(id);
    }

 
    
}
