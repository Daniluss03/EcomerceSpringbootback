package com.example.demo.Controlador;



import com.example.demo.Modelo.Products;
import com.example.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/productos")


public class ProductsController {

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping("/crearproducto")
    public ResponseEntity<Products> crearProducto(@RequestBody Products producto) {
       

        Products nuevoProducto = productoRepository.save(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> obtenerProductoPorId(@PathVariable Long id) {
        Products producto = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Products>> obtenerTodosLosProductos() {
        List<Products> listaProductos = productoRepository.findAll();
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

    @GetMapping("/byname/{productName}")
    public ResponseEntity<Products> obtenerProductoPorNombre(@PathVariable String productName) {
        Products producto = productoRepository.findByProductName(productName);
        if (producto == null) {
            throw new NoSuchElementException("Producto no encontrado");
        }
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/categoria/{productCategory}")
    public ResponseEntity<List<Products>> obtenerProductoPorCategoria(@PathVariable String productCategory) {
        List<Products> productos = productoRepository.findByCategory(productCategory);
        if (productos.isEmpty()) {
            throw new NoSuchElementException("Productos no encontrados para la categoría especificada");
        }
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    


    @PutMapping("/{id}")
    public ResponseEntity<Products> editarProducto(@PathVariable Long id, @RequestBody Products productoActualizado) {
        
        Products producto = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado"));

     
        Products productoGuardado = productoRepository.save(producto);
        return new ResponseEntity<>(productoGuardado, HttpStatus.OK);
    }
}
