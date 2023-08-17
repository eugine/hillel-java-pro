package ua.ithillel.log;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FileLogger {

    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void info(String message) {

        var output = new StringBuilder();
        output.append("[");
        output.append(LocalDateTime.now());
        output.append("]");
        output.append("[INFO]");
        output.append(" Message: ");
        output.append(message);

        var result = output.toString();

    }

    public void debug(String message) {
        if (config.level().equals(LoggingLevel.INFO)) {
            return;
        }
//        .....
    }
}

/*

| LEVEL     | info() | debug() |
| INFO	    |   +    |   --    |
| DEBUG     |   +    |   +     |




 */
