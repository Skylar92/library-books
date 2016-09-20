package com.library.books.integration.response;

/**
 * Created by skylar on 13.07.16.
 * Global interface for all response from server side
 */
public interface AbstractResponse {

    /**
     * @return status of request on server. If true - there are was error on server after request
     */
    boolean isError();

    /**
     * @return message of error
     */
    String getMessage();


}
