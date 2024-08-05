package com.bncn.inditex.exception;

import com.bncn.inditex.dto.PricesGet400Response;
import com.bncn.inditex.dto.PricesGet404Response;
import org.apache.http.HttpStatus;

public class PriceNotFoundException extends RuntimeException {
    private final Object response;
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
