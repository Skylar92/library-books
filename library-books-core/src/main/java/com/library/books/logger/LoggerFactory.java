package com.library.books.logger;

/**
 * Created by skylar on 20.09.16.
 */
public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new DefaultLogger(false);
    }

    public static Logger getLogger(Class aClass) {
        return new DefaultLogger(false);
    }

}
