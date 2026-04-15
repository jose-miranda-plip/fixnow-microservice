package com.example.fixnow.exception;

public class IsIdDuplicadoException extends RuntimeException { // Inicio clase IsbnDuplicadoException

    public IsIdDuplicadoException(String mensaje) { // Constructor que recibe el mensaje de error
        super(mensaje); // Envía el mensaje a la clase padre RuntimeException
    } // Fin constructor

} // Fin clase IsbnDuplicadoException
