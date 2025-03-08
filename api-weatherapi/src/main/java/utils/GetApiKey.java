package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetApiKey {
    private Properties readApiKeys() throws IOException {
        Properties props = new Properties();
        InputStream input = new FileInputStream("src/main/resources/key.properties");
        props.load(input);
        return props;
    }

    public String takeApiKey(String keyProperty) throws IOException {
        String key = readApiKeys().getProperty(keyProperty);
        return key;
    }

}
