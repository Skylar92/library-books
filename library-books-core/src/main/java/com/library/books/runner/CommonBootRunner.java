package com.library.books.runner;

import com.library.books.runner.commandLine.CommandLineApplication;
import org.springframework.boot.CommandLineRunner;

/**
 * Created by skylar on 9/20/2016.
 */
public class CommonBootRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        CommandLineApplication commandLineParser = new CommandLineApplication(args);
        commandLineParser.processedArguments();
    }
}
