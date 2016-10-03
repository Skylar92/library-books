package com.library.books.integration;

/**
 * Created by mhalych on 9/30/2016.
 */
public interface Mapper<T, C> {

    /**
     *
     * @param t - target object to convert
     * @param aClass - class of return object
     * @return converted object
     */
    C convert(T t, Class<C> aClass);

    T reverseConvert(C c, Class<T> tClass);

}
