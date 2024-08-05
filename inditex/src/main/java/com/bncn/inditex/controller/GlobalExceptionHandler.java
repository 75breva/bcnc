package com.bncn.inditex.controller;

import com.bncn.inditex.exception.PriceNotFoundException;
import com.bncn.inditex.dto.PricesGet404Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase para manejar la excepciones y devolver codigo estado HTTP requerido (404,400)
 * Cuando se lance la excepcion PriceNotFoundException @ControllerAdvice se encarja de generar el codigo de error adecuado.
 * Si no tenemos este controlador el servidor no detectara el error que queremos enviar de la excepcion y devolvera siempre un 500
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<?> handlePriceNotFoundException(PriceNotFoundException ex) {
        if (ex.getHttpStatus() == HttpStatus.BAD_REQUEST.value()) {
            // Manejo del error 400
            return new ResponseEntity<>(ex.getResponse(), HttpStatus.BAD_REQUEST);
        } else {
            // Manejo del error 404
            return new ResponseEntity<>(ex.getResponse(), HttpStatus.NOT_FOUND);
        }
    }

    // Otros manejadores de excepciones si es necesario
}
