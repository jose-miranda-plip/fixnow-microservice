package com.example.fixnow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Incidencia {

    private Integer idIncidencia;
    private String descripcion;
    private String estado;
    private String prioridad;
    private Integer usuarioId;
}
