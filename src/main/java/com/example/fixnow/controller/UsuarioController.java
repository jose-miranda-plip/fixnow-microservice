package com.example.fixnow.controller;

import com.example.fixnow.service.UsuarioService;
import com.example.fixnow.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioService.getUsuario());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Usuario u) {
        return ResponseEntity.ok(usuarioService.saveUsuario(u));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable int id) {
        try {
            return ResponseEntity.ok(usuarioService.getUsuarioId(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable int id) {
        return ResponseEntity.ok(usuarioService.eliminar(id));
    }

    @PutMapping("{id}")
    public Usuario actualizarUpdate(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        return usuarioService.actualizar(usuario);
    }
}