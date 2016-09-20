package com.library.books.handlers;

import com.library.books.integration.response.AbstractResponse;
import com.library.books.integration.response.Response;
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
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public AbstractResponse handleException(Exception ex) {
        logger.log(Level.INFO, ex.getMessage(), ex);
        return Response.fail(ex.getMessage());
    }

    //// TODO: 20.09.16 add exception handler to ServiceTemporaryNotWorking class


}
