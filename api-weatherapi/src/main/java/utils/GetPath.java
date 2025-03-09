package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPath {

    private Properties readPath() throws IOException {
        Properties props = new Properties();
        InputStream input = new FileInputStream("src/main/resources/paths.properties");
        props.load(input);
        return props;
    }

    public String takePath(String keyProperty) throws IOException {
        String key = readPath().getProperty(keyProperty);
        return key;
    }
}
