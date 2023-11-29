package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modelo.Products;

public interface ProductoRepository extends JpaRepository<Products,Long> {
    Products findByProductName(String productName);
    List<Products> findByCategory(String category);
}

