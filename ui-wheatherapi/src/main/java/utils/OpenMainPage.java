package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class OpenMainPage {

    public Properties readUrlProperties() throws IOException {
        Properties props = new Properties();
        InputStream input = new FileInputStream("src/main/resources/urls.properties");
        props.load(input);
        return props;
    }


    public void takeUrl(String keyProperty) throws IOException {
        open(readUrlProperties().getProperty(keyProperty));

    }


}
