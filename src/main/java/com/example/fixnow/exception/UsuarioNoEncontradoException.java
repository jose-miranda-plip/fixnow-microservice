package com.example.fixnow.exception;

public class UsuarioNoEncontradoException extends RuntimeException { // Inicio clase LibroNoEncontradoException

    public UsuarioNoEncontradoException(String mensaje) { // Constructor que recibe el mensaje de error
        super(mensaje); // Envía el mensaje a la clase padre RuntimeException
    } // Fin constructor

} // Fin clase LibroNoEncontradoException
