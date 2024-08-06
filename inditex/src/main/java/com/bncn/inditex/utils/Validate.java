package com.bncn.inditex.utils;

import com.bncn.inditex.exception.PriceNotFoundException;

public class Validate {


    public static void validateParammeters(String applicationDate ){

        if ( applicationDate.isEmpty()) {
            throw new PriceNotFoundException("Parámetros de solicitud inválidos.", true);
        }

    }
}
