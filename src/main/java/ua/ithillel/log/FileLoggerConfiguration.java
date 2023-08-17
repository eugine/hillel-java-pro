package ua.ithillel.log;

public record FileLoggerConfiguration(
        String path,
        String prefix,
        LoggingLevel level,
        int maxSize
) {
}
