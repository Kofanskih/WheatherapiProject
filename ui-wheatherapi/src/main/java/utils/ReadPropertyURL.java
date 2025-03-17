package utils;

import com.codeborne.selenide.Selenide;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadPropertyURL {
    private static final String MAIN_URL = "src/main/resources/urls.properties";

    private static Properties readUrlProperties() throws IOException {
        Properties props = new Properties();
        InputStream input = new FileInputStream(MAIN_URL);
        props.load(input);
        return props;
    }


    public static String getMainUrlProperty() throws IOException {
       return readUrlProperties().getProperty("main_url");

    }


}
