package ua.ithillel.log;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        var config = new FileLoggerConfiguration(
                "./logs",
                "hillel_",
                LoggingLevel.DEBUG,
                512
        );

        var fileLogger = new FileLogger(config);


        fileLogger.debug("My debug message");
        fileLogger.info("My info message");
    }
}
