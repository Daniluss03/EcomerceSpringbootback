package com.example.demo.Servicio;
import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modelo.Provedores;
import com.example.demo.Repository.ProvedorRepo;
import java.util.Optional;

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
        // Supongamos que tienes un método findById en tu repositorio para buscar por ID
        Optional<Provedores> proveedorOptional = provedorRepo.findById(id);

        // Verificar si se encontró el proveedor con el ID dado
        if (proveedorOptional.isPresent()) {
            return proveedorOptional.get();
        } else {
            // Aquí puedes manejar el caso en el que no se encuentra el proveedor
            // Puedes lanzar una excepción, devolver un valor predeterminado o hacer algo más según tus requerimientos.
            // Por ejemplo, lanzar una excepción de Proveedor no encontrado
            throw new RuntimeException("Proveedor no encontrado con ID: " + id);
        }
    }
    
    @Override
    public Provedores buscarprovedoreditar(Provedores provedor) {
     
        Optional<Provedores> optionalProveedor = provedorRepo.findById(Long.valueOf(provedor.getIdprovedor()));

        if (optionalProveedor.isPresent()) {
            // Si el proveedor existe, actualiza sus campos con los nuevos valores
            Provedores proveedorExistente = optionalProveedor.get();
            proveedorExistente.setDireccion(provedor.getDireccion());
            proveedorExistente.setNombre(provedor.getNombre());
            proveedorExistente.setCiudad(provedor.getCiudad());
            proveedorExistente.setTelefono(provedor.getTelefono());
            proveedorExistente.setNitt(provedor.getNitt());

            // Luego, guarda el proveedor actualizado en la base de datos
            return provedorRepo.save(proveedorExistente);
        } else {
            // Manejar el caso en el que el proveedor no existe
            throw new RuntimeException("Proveedor no encontrado con ID: "+provedor.getIdprovedor());
        }
    }

}
 
    
