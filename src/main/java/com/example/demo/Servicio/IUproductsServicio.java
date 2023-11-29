package com.example.demo.Servicio;

import java.util.List;

import com.example.demo.Modelo.Products;

public interface IUproductsServicio {
      List<Products> getproductos();
    Products   grabarprovedor(Products producto);
    Products  buscarprovedor(Long id);
    Products buscarproductoeditar(Products producto);
    int delete(Long id);


}
