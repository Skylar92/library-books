package com.library.books.logger;

import com.library.books.runner.commandLine.CommandLineProperties;
import com.library.books.utils.SystemPropertyUtils;

/**
 * Created by skylar on 20.09.16.
 */
public class LoggerFactory {

    private static boolean isDebug = SystemPropertyUtils.getPropertyAsBoolean(CommandLineProperties.DEBUG);

    public static Logger getLogger(String name) {
        return new DefaultLogger(name, isDebug);
    }

    public static Logger getLogger(Class aClass) {
        return new DefaultLogger(aClass.getCanonicalName(), isDebug);
    }


}
