package weatherapi;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.testng.CucumberOptions;


//@CucumberOptions(glue = {"WheatherapiProject", "ui-wheatherapi", "src", "test", "java", "<weatherapi>"})
@CucumberOptions(features = "classpath:ui_weatherapi.src.test.resources.weatherapi.scenarios",
        glue = {"classpath:ui_weatherapi.src.java.test.weatherapi"})
public class BeforeStepWeatherapi {

    @Given("Open the main page {string}")
    public void openTheMainPage(String url) {
        Configuration.timeout = 60000;
        Selenide.open(url);
        throw new io.cucumber.java.PendingException();
    }

    @Given("Open the main page {string}")
    public void open_the_main_page(String url) {
        Configuration.timeout = 60000;
        Selenide.open(url);
        throw new io.cucumber.java.PendingException();
    }
}
