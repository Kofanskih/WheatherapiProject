package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetMainURL {
    private final String MAIN_URL = "src/main/resources/urls.properties";

    private Properties readMainUrl() throws IOException {
        Properties props = new Properties();
        InputStream input = new FileInputStream(MAIN_URL);
        props.load(input);
        return props;
    }

    public String takeMainURL(String keyProperty) throws IOException{
        String key = readMainUrl().getProperty(keyProperty);
        return key;

    }

}
