package com.example.fixnow.service;

import com.example.fixnow.model.Incidencia;
import com.example.fixnow.model.Usuario;
import com.example.fixnow.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository repository;

    public List<Incidencia> listar() {
        return repository.obtenerIncidencia();
    }

    public Incidencia crear(Incidencia i) {

        if (i.getDescripcion() == null || i.getDescripcion().isEmpty()) {
            throw new RuntimeException("La descripción es obligatoria");
        }

        if (i.getEstado() == null || i.getEstado().isEmpty()) {
            throw new RuntimeException("El estado es obligatorio");
        }

        if (i.getPrioridad() == null || i.getPrioridad().isEmpty()) {
            throw new RuntimeException("La prioridad es obligatoria");
        }

        return repository.guardar(i);
    }


    public Incidencia obtenerPorId(Integer id) {

        Incidencia i = repository.buscarPorId(id);


        if (i == null) {
            throw new RuntimeException("Incidencia no encontrada");
        }

        return i;
    }


    public Incidencia actualizar(Integer id, Incidencia nueva) {

        Incidencia existente = obtenerPorId(id);


        if (nueva.getDescripcion() != null && !nueva.getDescripcion().isEmpty()) {
            existente.setDescripcion(nueva.getDescripcion());
        }

        if (nueva.getEstado() != null && !nueva.getEstado().isEmpty()) {
            existente.setEstado(nueva.getEstado());
        }

        if (nueva.getPrioridad() != null && !nueva.getPrioridad().isEmpty()) {
            existente.setPrioridad(nueva.getPrioridad());
        }

        return existente;
    }


    public void eliminar(Integer id) {

        Incidencia i = repository.buscarPorId(id);

        if (i == null) {
            throw new RuntimeException("No se puede eliminar, incidencia no existe");
        }

        repository.eliminar(id);
    }

    public List<Incidencia> filtrarPorPrioridad(String prioridad) {
        return repository.obtenerIncidencia()
                .stream()
                .filter(i -> i.getPrioridad().equalsIgnoreCase(prioridad))
                .toList();
    }
}