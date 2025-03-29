package utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetMainURL {
    private static final String MAIN_URL = "src/main/resources/urls.properties";

    private static Properties readMainUrl(){
        Properties props = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(MAIN_URL);
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        return props;
    }

    public static String takeMainURL() {
        String key = readMainUrl().getProperty("main.url");
        return key;

    }

    @SneakyThrows
    private Properties readMainUrl1(){
        Properties props = new Properties();
        InputStream input = null;
            input = new FileInputStream(MAIN_URL);
            props.load(input);

        return props;
    }

}
