package com.example.fixnow.exception; // Paquete donde se encuentra el manejador global de errores

import org.springframework.http.HttpStatus; // Permite usar códigos HTTP
import org.springframework.http.ResponseEntity; // Permite devolver respuestas HTTP completas
import org.springframework.validation.FieldError; // Permite acceder a los errores de validación por campo
import org.springframework.web.bind.MethodArgumentNotValidException; // Excepción que Spring lanza cuando falla @Valid
import org.springframework.web.bind.annotation.ExceptionHandler; // Permite capturar excepciones específicas
import org.springframework.web.bind.annotation.RestControllerAdvice; // Marca esta clase como manejador global de errores

import java.util.LinkedHashMap; // Permite crear un mapa ordenado
import java.util.Map; // Importa la interfaz Map

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarErroresDeValidacion(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new LinkedHashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errores.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<String> manejarUsuarioNoEncontrado(UsuarioNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IsIdDuplicadoException.class) // Captura errores de ISBN duplicado
    public ResponseEntity<String> manejarIsbnDuplicado(IsIdDuplicadoException ex) { // Método para manejar ISBN duplicado
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()); // Retorna 400 con el mensaje del error
    } // Fin método manejarIsbnDuplicado

    @ExceptionHandler(Exception.class) // Captura cualquier error inesperado
    public ResponseEntity<String> manejarErrorGeneral(Exception ex) { // Método para manejar errores generales
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor."); // Retorna 500 con mensaje general
    } // Fin método manejarErrorGeneral

} // Fin de la clase GlobalExceptionHandler
