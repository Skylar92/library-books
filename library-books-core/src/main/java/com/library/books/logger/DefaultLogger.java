package com.library.books.logger;

import org.slf4j.Marker;

/**
 * todo investigate best way to make delegate logger
 * Created by skylar on 20.09.16.
 */
public class DefaultLogger implements Logger {

    private final boolean isDebugMode;
    private final org.slf4j.Logger logger;

    protected DefaultLogger(String nameLogger, boolean isDebugMode) {
        this.isDebugMode = isDebugMode;
        logger = org.slf4j.LoggerFactory.getLogger(nameLogger);
    }

    @Override
    public void debug(String message) {
        if (isDebugMode)
            logger.debug(message);
    }

    @Override
    public void debug(Object... objects) {
        if (isDebugMode)
            logger.debug(null, objects);
    }

    @Override
    public void debug(String message, Object... objects) {
        if (isDebugMode) {
            logger.debug(message, objects);
        }
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(Object... objects) {
        logger.info(null, objects);
    }

    @Override
    public void info(String message, Object... objects) {
        logger.info(message, objects);
    }

    @Override
    public void warning(String message) {

    }

    @Override
    public void warning(Exception ex) {

    }

    @Override
    public void warning(Object... objects) {

    }

    @Override
    public void warning(String message, Object... objects) {

    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(Exception ex) {
        logger.error(Marker.ANY_MARKER, ex);
    }

    @Override
    public void error(String message, Exception ex) {
        logger.error(message, ex);
    }

}
