package ua.ithillel.log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration load(String filePath) throws IOException {
        InputStream is = FileLoggerConfigurationLoader.class.getResourceAsStream(filePath);

        var properties = new Properties();
        properties.load(is);

        var path = properties.getProperty("path");
        var prefix = properties.getProperty("prefix");
        var level = LoggingLevel.valueOf(properties.getProperty("level"));
        var size = Integer.parseInt(properties.getProperty("max-size"));

        return new FileLoggerConfiguration(path, prefix, level, size);
    }

    public static void main(String[] args) throws IOException {
        FileLoggerConfiguration result = load("/file-logger-test.properties");
        System.out.println(result);
    }
}
