package com.library.books.utils;

import org.springframework.util.StringUtils;

/**
 * Created by skylar on 19.07.16.
 */
public final class ValidationUtils {

    private ValidationUtils() {}


    public static void throwExceptionIfValueZero(int value) {
        if (value == 0)
            throw new IllegalArgumentException("Value is equal 0");
    }

    public static void throwExceptionIfNull(Object o) {
        if (o == null)
            throw new IllegalArgumentException("Object is null");
    }

    public static void throwExceptionIfEmpty(String s) {
        if (StringUtils.isEmpty(s))
            throw new IllegalArgumentException("String is null or empty");
    }

}
