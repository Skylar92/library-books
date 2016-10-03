package com.library.books.handler;

import com.library.books.integration.AbstractResponse;
import com.library.books.integration.Response;
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
public class GlobalServerExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalServerExceptionHandler.class.getName());

    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public AbstractResponse handleException(Exception ex) {
        logger.log(Level.INFO, ex.getMessage(), ex);
        return Response.fail(ex.getMessage());
    }

}
