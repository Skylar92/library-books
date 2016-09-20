package com.library.books.logger;

/**
 * Created by skylar on 20.09.16.
 */
public class DefaultLogger implements Logger {

    private final boolean isDebugMode;

    protected DefaultLogger(boolean isDebugMode) {
        this.isDebugMode = isDebugMode;
    }

    @Override
    public void debug(String message) {

    }

    @Override
    public void debug(Object... objects) {

    }

    @Override
    public void debug(String message, Object... objects) {

    }

    @Override
    public void info(String message) {

    }

    @Override
    public void info(Object... objects) {

    }

    @Override
    public void info(String message, Object... objects) {

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

    }

    @Override
    public void error(Exception ex) {

    }

    @Override
    public void error(String message, Exception ex) {

    }

}
