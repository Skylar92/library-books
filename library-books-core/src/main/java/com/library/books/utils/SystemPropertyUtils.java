package com.library.books.utils;

/**
 * Created by mhalych on 9/28/2016.
 */
public class SystemPropertyUtils {

    private SystemPropertyUtils() {

    }

    public static boolean getPropertyAsBoolean(String propertyName, boolean defaultValue) {
        String property = System.getProperty(propertyName, Boolean.toString(defaultValue));
        Boolean aProperty = Boolean.valueOf(property);
        return aProperty == null ? defaultValue : aProperty;
    }

    public static boolean getPropertyAsBoolean(String propertyName) {
        return getPropertyAsBoolean(propertyName, false);
    }

}
