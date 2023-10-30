package com.example.demo.Servicio;
import java.util.List;
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
    public int delete(Long id) {
         provedorRepo.deleteById(id);
        return 0;
    }

    @Override
    public Provedores buscarprovedor(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarprovedor'");
    };
    
}
