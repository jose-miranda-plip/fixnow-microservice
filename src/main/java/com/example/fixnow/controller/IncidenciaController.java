package com.example.fixnow.controller;

import com.example.fixnow.model.Incidencia;
import com.example.fixnow.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService service;

    @GetMapping
    public ResponseEntity<List<Incidencia>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.obtenerPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Incidencia i) {
        try {
            return ResponseEntity.ok(service.crear(i));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Incidencia i) {
        try {
            return ResponseEntity.ok(service.actualizar(id, i));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok("Incidencia eliminada");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/prioridad/{prioridad}")
    public ResponseEntity<?> filtrar(@PathVariable String prioridad) {
        return ResponseEntity.ok(service.filtrarPorPrioridad(prioridad));
    }


    @GetMapping("/status")
    public String status(){
        return "Servicio funcionando correctamente";

    @GetMapping("/test")
    public String test() {
        return "OK";

    }
}
