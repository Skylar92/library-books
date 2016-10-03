package com.library.books.handlers;

import com.library.books.exceptions.ServerException;
import com.library.books.integration.AbstractResponse;
import com.library.books.integration.Response;
import com.library.books.responses.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by skylar on 13.07.16.
 */
@ControllerAdvice
public class GlobalClientExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalClientExceptionHandler.class.getName());

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public AbstractResponse handleException(Exception ex) {
        logger.log(Level.INFO, ex.getMessage(), ex);
        return Response.fail(ex.getMessage());
    }

    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @ExceptionHandler(ServerException.class)
    @ResponseBody
    public ResponseException handleException(ServerException ex) {
        logger.log(Level.INFO, ex.getMessage(), ex);
        return new ResponseException(ex.getErrorCode(), ex.getMessage());
    }


}
