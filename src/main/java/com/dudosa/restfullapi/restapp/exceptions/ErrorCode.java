package com.dudosa.restfullapi.restapp.exceptions;


public enum ErrorCode {
    //Internal Errors: 1 to 0999
    GENERIC_ERROR("DS-0001", "The system is enable to complete the request. Contact the system support"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED("DS-0002", "Requested media is not supported. Please add 'Accept' header"),
    HTTP_MESSAGE_NOT_WRITABLE("DS-0003", "Missing 'Accept' header. Please use application/json or application/xml as 'Accept' value"),
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("DS-0004", "Requested 'Accept' header not supported. Please use application.json or application/xml as 'Accept' value"),
    JSON_PARSE_ERROR("DS-0005","Make sure request payload is a valid json object"),
    HTTP_MASSAGE_NOT_READABLE("DS-0006","Make sure request payload is a valid json or xml object according to 'content-Type.");
    private  String errorCode;
    private String errMsgKey;

    ErrorCode (final String errorCode, final String errorMessage){
        this.errorCode = errorCode;
        this.errMsgKey = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrMsgKey() {
        return errMsgKey;
    }
}
