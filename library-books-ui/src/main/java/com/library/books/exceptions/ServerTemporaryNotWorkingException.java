package com.library.books.exceptions;

/**
 * Created by mhalych on 9/29/2016.
 */
public class ServerTemporaryNotWorkingException extends ServerException {

    private static final ErrorCode DEFAULT_ERROR_CODE = ErrorCode.SERVER_NOT_WORKING;

    public ServerTemporaryNotWorkingException(String message) {
        super(DEFAULT_ERROR_CODE, message);
    }

    public ServerTemporaryNotWorkingException(String message, Throwable cause) {
        super(DEFAULT_ERROR_CODE, message, cause);
    }

    public ServerTemporaryNotWorkingException(Throwable cause) {
        super(DEFAULT_ERROR_CODE, cause);
    }

    public ServerTemporaryNotWorkingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(DEFAULT_ERROR_CODE, message, cause, enableSuppression, writableStackTrace);
    }

    public ServerTemporaryNotWorkingException() {
        super(DEFAULT_ERROR_CODE);
    }
}
