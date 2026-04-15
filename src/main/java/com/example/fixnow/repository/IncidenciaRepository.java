package com.example.fixnow.repository;


import com.example.fixnow.model.Incidencia;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IncidenciaRepository {

    private List<Incidencia> listaIncidencia = new ArrayList<>();
    private int ultimoId = 0;

    public Incidencia guardar(Incidencia incidencia){
        ultimoId++;
        incidencia.setIdIncidencia(ultimoId);
        listaIncidencia.add(incidencia);
        return incidencia;
    }

    public Incidencia buscarPorId(int id) {
        for (Incidencia incidencia : listaIncidencia){
            if(incidencia.getIdIncidencia() == id) {
                return incidencia;
            }
        }
        return null;
    }

    public Incidencia actualizar(int id, Incidencia incidenciaActualizado) {
        for (int i = 0; i < listaIncidencia.size(); i++) {
            if(listaIncidencia.get(i).getIdIncidencia() == id){
                incidenciaActualizado.setIdIncidencia(id);
                listaIncidencia.set(i, incidenciaActualizado);
                return  incidenciaActualizado;
            }
        }
        return null;
    }

    public boolean eliminar(int id){
        for (int i = 0; i < listaIncidencia.size(); i++) {
            if (listaIncidencia.get(i).getIdIncidencia() == id) {
                listaIncidencia.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Incidencia> obtenerIncidencia() {
        return listaIncidencia;
    }
}
