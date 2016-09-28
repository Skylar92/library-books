package com.library.books.runner.commandLine;

import com.library.books.logger.Logger;
import com.library.books.logger.LoggerFactory;
import org.apache.commons.cli.*;

/**
 * Created by skylar on 9/20/2016.
 */
public class CommandLineApplication {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineApplication.class);

    private final String[] args;
    private final Options options;

    public CommandLineApplication(String[] args) {
        this.args = args;
        this.options = new Options();
        setUpOptions();
    }

    private void setUpOptions() {
        options.addOption(CommandLineProperties.DEBUG, false, CommandLineProperties.DEBUG_DESCRIPTION);
    }

    public void processedArguments() {
        if (args == null || args.length == 0)
            return;
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine commandLine = parser.parse(options, args);
            processCommandLineResult(commandLine);
        } catch (ParseException e) {
            logger.error("Error parsing command line", e);
        }
    }

    private void processCommandLineResult(CommandLine commandLine) {
        processDebugOption(commandLine);
    }

    private void processDebugOption(CommandLine commandLine) {
        if (commandLine.hasOption(CommandLineProperties.DEBUG))
            System.setProperty(CommandLineProperties.DEBUG, "true");
    }


}
