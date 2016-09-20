package com.library.books.integration.response;

/**
 * Created by skylar on 13.07.16.
 */
public class Response implements AbstractResponse {

    protected boolean error;
    protected String message;

    public Response(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean isError() {
        return error;
    }

    public static Response ok() {
        return new Response(false, null);
    }

    public static Response fail(String message) {
        return new Response(true, message);
    }

    public static Response fail() {
        return new Response(true, null);
    }
}
