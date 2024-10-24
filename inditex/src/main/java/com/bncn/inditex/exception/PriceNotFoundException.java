package com.bncn.inditex.exception;

import com.bncn.inditex.dto.PricesGet400Response;
import com.bncn.inditex.dto.PricesGet404Response;
import org.apache.http.HttpStatus;

/**
 *  Funcion para controlar las dos Excepciones indicadas en la api.yml que son:
 *  Respuesta 404 : En caso de no encontrar ningun precio
 *  Respuesta 400 : En caso de algun parametro invalido
 */
public class PriceNotFoundException extends RuntimeException {
    private final transient Object response; // sonar Make "response" transient or serializable
    private final int httpStatus;

    // Constructor para 404 Not Found
    public PriceNotFoundException(String message) {
        super(message);
        this.response = new PricesGet404Response().message(message);
        this.httpStatus = HttpStatus.SC_NOT_FOUND;
    }

    // Constructor para 400 Bad Request
    public PriceNotFoundException(String message, boolean isBadRequest) {
        super(message);
        this.response = isBadRequest ? new PricesGet400Response().message(message) : new PricesGet404Response().message(message);
        this.httpStatus = isBadRequest ? HttpStatus.SC_BAD_REQUEST : HttpStatus.SC_NOT_FOUND;
    }

    public Object getResponse() {
        return response;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
