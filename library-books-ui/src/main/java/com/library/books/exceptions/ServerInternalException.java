package com.library.books.exceptions;

/**
 * Created by mhalych on 9/29/2016.
 */
public class ServerInternalException extends ServerException {

    private static final ErrorCode DEFAULT_ERROR_CODE = ErrorCode.SERVER_INTERNAL_ERROR;

    public ServerInternalException(String message) {
        super(DEFAULT_ERROR_CODE, message);
    }

    public ServerInternalException(String message, Throwable cause) {
        super(DEFAULT_ERROR_CODE, message, cause);
    }

    public ServerInternalException(Throwable cause) {
        super(DEFAULT_ERROR_CODE, cause);
    }

    public ServerInternalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(DEFAULT_ERROR_CODE, message, cause, enableSuppression, writableStackTrace);
    }

    public ServerInternalException() {
        super(DEFAULT_ERROR_CODE);
    }
}
