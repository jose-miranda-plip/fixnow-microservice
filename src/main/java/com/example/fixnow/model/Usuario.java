package com.example.fixnow.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    private Integer idUsuario;
    private String nombre;
    private String correo;
    private String telefono;
    private String rol;
}
