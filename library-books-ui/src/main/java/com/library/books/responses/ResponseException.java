package com.library.books.responses;

import com.library.books.exceptions.ErrorCode;
import com.library.books.integration.Response;

/**
 * Created by mhalych on 9/29/2016.
 */
public class ResponseException extends Response {

    private ErrorCode errorCode;

    public ResponseException(boolean error, String message) {
        super(error, message);
        this.errorCode = ErrorCode.UNKNOWN;
    }

    public ResponseException(ErrorCode errorCode, String message) {
        super(true, message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
