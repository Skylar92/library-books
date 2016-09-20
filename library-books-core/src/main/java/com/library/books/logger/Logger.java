package com.library.books.logger;

/**
 * Created by skylar on 20.09.16.
 */
public interface Logger {

    //-------------------------- DEBUG METHODS ---------------------//

    void debug(String message);

    void debug(Object... objects);

    void debug(String message, Object... objects);

    //-------------------------- INFO METHODS ---------------------//


    void info(String message);

    void info(Object... objects);

    void info(String message, Object... objects);

    //-------------------------- WARNING METHODS ---------------------//

    void warning(String message);

    void warning(Exception ex);

    void warning(Object... objects);

    void warning(String message, Object... objects);


    //-------------------------- ERROR METHODS ---------------------//

    void error(String message);

    void error(Exception ex);

    void error(String message, Exception ex);


}
