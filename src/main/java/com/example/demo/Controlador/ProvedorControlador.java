package com.example.demo.Controlador;
import java.util.List;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Modelo.Provedores;
import com.example.demo.Servicio.ProvedoresServicio;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/provedores")
public class ProvedorControlador {
    
    @Autowired
    private ProvedoresServicio provedorservicio;

    @GetMapping("/list")
    public List<Provedores> consultarTodo() {
        return provedorservicio.getprovedores();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Provedores> getProveedorById(@PathVariable Long id) {
        Provedores proveedor = provedorservicio.getProveedorById(id);
        if (proveedor != null) {
            return ResponseEntity.ok(proveedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/crear")
    public ResponseEntity<Provedores> agregar(@RequestBody Provedores provedor) {
        Provedores obj = provedorservicio.grabarprovedor(provedor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        Provedores proveedor = provedorservicio.getProveedorById(id);
        if (proveedor != null) {
            provedorservicio.deleteProveedor(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<Provedores> updateProveedor(@RequestBody Provedores proveedor) {
        Provedores existingProveedor = provedorservicio.buscarprovedoreditar(proveedor);
        if (existingProveedor != null) {
            existingProveedor.setCiudad(proveedor.getCiudad());
            existingProveedor.setDireccion(proveedor.getDireccion());
            existingProveedor.setNombre(proveedor.getNombre());
            // Actualiza otros atributos si es necesario
            Provedores updatedProveedor = provedorservicio.grabarprovedor(existingProveedor);
            return ResponseEntity.ok(updatedProveedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
