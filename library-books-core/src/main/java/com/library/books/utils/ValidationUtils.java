package com.library.books.utils;

/**
 * Created by skylar on 19.07.16.
 */
public final class ValidationUtils {

    private ValidationUtils() {}


    public static void throwExceptionIfValueZero(int value) {
        if (value == 0)
            throw new IllegalArgumentException("Value is equal 0");
    }

}
