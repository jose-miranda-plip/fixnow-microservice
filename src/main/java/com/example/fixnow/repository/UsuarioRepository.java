package com.example.fixnow.repository;

import com.example.fixnow.exception.IsIdDuplicadoException;
import com.example.fixnow.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    public UsuarioRepository(){
        listaUsuarios.add(new Usuario(1,"Renato","renaelpro@gmail.com","123456","ADMIN"));
        listaUsuarios.add(new Usuario(2,"Tomas","tomas@gmail.com","552335","USER"));
        listaUsuarios.add(new Usuario(3,"Nicolas","nicolas@gmail.com","662347","USER"));
        listaUsuarios.add(new Usuario(4,"Daniel","daniel@gmail.com","834532","USER"));
        listaUsuarios.add(new Usuario(5,"Enrique","emrique@gmail.com","321734","USER"));
        listaUsuarios.add(new Usuario(6,"Gabriel","Gabriel@gmail.com","406294","ADMIN"));
        listaUsuarios.add(new Usuario(7,"Rick","rick@gmail.com","198672","USER"));
        listaUsuarios.add(new Usuario(8,"Eduardo","eduardo@gmail.com","542178","USER"));
        listaUsuarios.add(new Usuario(9,"Benjamin","benjamin@gmail.com","097841","USER"));
        listaUsuarios.add(new Usuario(10,"Renato","renaelpro@gmail.com","728971","ADMIN"));
    }

    public List<Usuario> obtenerUsuarios(){
        return listaUsuarios;
    }

    public Usuario buscarPorId(int id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario() == id) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario guardar(Usuario u){
        listaUsuarios.add(u);
        return u;
    }


    public Usuario actualizar(Usuario usu) {
        int id = 0;
        int idPosicion = 0;

        for(int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getIdUsuario() == usu.getIdUsuario()) {
                id = usu.getIdUsuario();
                idPosicion = i;
            }
        }
        Usuario usuario1 = new Usuario();
        usuario1.setIdUsuario(id);
        usuario1.setNombre(usu.getNombre());
        usuario1.setCorreo(usu.getCorreo());
        usuario1.setTelefono(usu.getTelefono());
        usuario1.setRol(usu.getRol());

        listaUsuarios.set(idPosicion, usuario1);
        return usuario1;
    }

    public void eliminar(int id) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            listaUsuarios.remove(usuario);
        }
    }

    public int totalUsuarios() {
        return listaUsuarios.size();
    }


}
