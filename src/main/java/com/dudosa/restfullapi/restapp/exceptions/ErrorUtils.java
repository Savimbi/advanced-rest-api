package com.dudosa.restfullapi.restapp.exceptions;

public class ErrorUtils {
    private ErrorUtils(){}

    public static Error createError(final String errMsgKey, final String errorCode, final Integer httpStatusCode ){
        Error error = new Error();
        error.setErrorCode(errorCode);
        error.setMessage(errMsgKey);
        error.setStatus(httpStatusCode);
        return error;
    }
}
