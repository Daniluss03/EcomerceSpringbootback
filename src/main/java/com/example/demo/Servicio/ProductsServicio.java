package com.example.demo.Servicio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


import com.example.demo.Modelo.Products;
import com.example.demo.Repository.ProductoRepository;
import java.util.Optional;
public class ProductsServicio implements IUproductsServicio{


@Autowired
private ProductoRepository productorepo;
 
    @Override
    public List<Products> getproductos() {
         return productorepo.findAll();
    }       
    
    @Override
    public Products grabarprovedor(Products provedor){
        return productorepo.save(provedor);
    };
 
 

    @Override
    public int delete(Long id) {
         productorepo.deleteById(id);
        return 0;
    }

    @Override
    public Products buscarprovedor(Long id) {
        // Supongamos que tienes un método findById en tu repositorio para buscar por ID
        Optional<Products> productooptional = productorepo.findById(id);

        // Verificar si se encontró el proveedor con el ID dado
        if (productooptional.isPresent()) {
            return productooptional.get();
        } else {
            // Aquí puedes manejar el caso en el que no se encuentra el proveedor
            // Puedes lanzar una excepción, devolver un valor predeterminado o hacer algo más según tus requerimientos.
            // Por ejemplo, lanzar una excepción de Proveedor no encontrado
            throw new RuntimeException("Proveedor no encontrado con ID: " + id);
        }
    }
    
    @Override
    public Products buscarproductoeditar(Products producto) {
        // Aquí puedes incluir la lógica específica para buscar y editar el proveedor
        // Primero, verifica si el proveedor existe en la base de datos
        Optional<Products> optionalProveedor = productorepo.findById(Long.valueOf(producto.getproductid()));

        if (optionalProveedor.isPresent()) {
            // Si el proveedor existe, actualiza sus campos con los nuevos valores
            Products productoExistente = optionalProveedor.get();
            productoExistente.setgetproductname(producto.getproductName());
            productoExistente.setdescription(producto.getdescription());
            productoExistente.setguantityAvailable(producto.getquantityAvailable());
            productoExistente.setprice(producto.getprice());
        


            // Luego, guarda el proveedor actualizado en la base de datos
            return productorepo.save(productoExistente);
        } else {
           
     
        }
        return producto;
        }






}
 