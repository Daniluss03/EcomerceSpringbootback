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
    public Provedores BuscarporId(@PathVariable Long id) {
        return provedorservicio.buscarprovedor(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Provedores> agregar(@RequestBody Provedores provedor) {
        Provedores obj = provedorservicio.grabarprovedor(provedor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Provedores> Editar(@RequestBody Provedores provedor) {
        Provedores obj = provedorservicio.buscarprovedor((long) provedor.getIdprovedor());

        if (obj != null) {
            obj.setDireccion(provedor.getDireccion());
            obj.setNombre(provedor.getNombre());
            obj.setCiudad(provedor.getCiudad());
            provedorservicio.grabarprovedor(obj);
        } else {
            return new ResponseEntity<Provedores>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Provedores> Editar(@PathVariable Long id) {
        Provedores obj = provedorservicio.buscarprovedor(id);

        if (obj != null) {
            provedorservicio.delete(id);
        } else {
            return new ResponseEntity<Provedores>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
