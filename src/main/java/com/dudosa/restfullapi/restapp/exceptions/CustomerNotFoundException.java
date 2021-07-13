package com.dudosa.restfullapi.restapp.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String errMsgKey;
    private final String errorCode;

    public CustomerNotFoundException(ErrorCode code) {
        super(code.getErrMsgKey());
        this.errMsgKey = code.getErrMsgKey();
        this.errorCode = code.getErrorCode();
    }

    public CustomerNotFoundException(final String message) {
        super(message);
        this.errMsgKey = ErrorCode.CUSTOMER_NOT_FOUND.getErrMsgKey();
        this.errorCode = ErrorCode.CUSTOMER_NOT_FOUND.getErrorCode();
    }

    public String getErrMsgKey() {
        return errMsgKey;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
