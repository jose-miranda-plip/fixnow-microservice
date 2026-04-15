package com.example.fixnow.service;

import com.example.fixnow.exception.IsIdDuplicadoException;
import com.example.fixnow.exception.UsuarioNoEncontradoException;
import com.example.fixnow.model.Usuario;
import com.example.fixnow.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuario() {
        return usuarioRepository.obtenerUsuarios();
    }

    public Usuario saveUsuario(Usuario usuario) {

        // 🔥 EVITA USAR ID EN CREACIÓN
        if (usuario.getIdUsuario() != null) {
            Usuario usuarioExistente = usuarioRepository.buscarPorId(usuario.getIdUsuario());

            if (usuarioExistente != null) {
                throw new IsIdDuplicadoException("Ya existe un usuario con ese ID");
            }
        }

        return usuarioRepository.guardar(usuario);
    }

    public Usuario getUsuarioId(int id) {
        Usuario usuario = usuarioRepository.buscarPorId(id);

        if (usuario == null) {
            throw new UsuarioNoEncontradoException("Usuario con ID " + id + " no encontrado.");
        }
        return usuario;
    }

    public Usuario actualizar(Usuario usuario) {
        Usuario usuarioActual = usuarioRepository.buscarPorId(usuario.getIdUsuario());

        if (usuarioActual == null) {
            throw new UsuarioNoEncontradoException("Usuario con ID " + usuario.getIdUsuario() + " no encontrado.");
        }

        return usuarioRepository.actualizar(usuario);
    }

    public String eliminar(int id) {
        Usuario usuario = usuarioRepository.buscarPorId(id);

        if (usuario == null) {
            throw new UsuarioNoEncontradoException("Usuario con ID " + id + " no encontrado.");
        }
        usuarioRepository.eliminar(id);
        return "Usuario eliminado correctamente.";
    }
}