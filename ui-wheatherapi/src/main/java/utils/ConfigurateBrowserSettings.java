package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.MutableCapabilities;

public class ConfigurateBrowserSettings {
    public void setUp(){
        Configuration.browserSize = "1980x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 5;
        Configuration.headless = true;
    }

    public void setUpRemoteBrowser(){
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browserVersion = "127.0";
        Configuration.browser = "chrome";
        Configuration.timeout = 5;
        MutableCapabilities options = new MutableCapabilities();
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        options.setCapability("screenResolution", "1920x1080x24");

        Configuration.browserCapabilities.setCapability("selenoid:options", options);

    }

    public void setUpRemoteServer(){
        Configuration.remote = "http://134.199.212.192:4444/wd/hub";
        Configuration.browserVersion = "128.0";
        Configuration.browser = "chrome";
        Configuration.timeout = 5;
        MutableCapabilities options = new MutableCapabilities();
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        options.setCapability("screenResolution", "1920x1080x24");

        Configuration.browserCapabilities.setCapability("selenoid:options", options);

    }
}
