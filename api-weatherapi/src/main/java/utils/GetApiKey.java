package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetApiKey {
    private final String API_KEY = "src/main/resources/key.properties";

    private Properties readApiKeys() throws IOException {
        Properties props = new Properties();
        InputStream input = new FileInputStream(API_KEY);
        props.load(input);
        return props;
    }

    public String takeApiKey(String keyProperty) throws IOException {
        String key = readApiKeys().getProperty(keyProperty);
        return key;
    }

}
