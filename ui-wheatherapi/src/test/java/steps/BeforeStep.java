package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "classpath:ui_weatherapi.src.test.resources.features",
        glue = {"classpath:ui_weatherapi.src.test.java.steps"},
        snippets = CucumberOptions.SnippetType.UNDERSCORE)
public class BeforeStep {
    @Given("Open main page {string}")
    public void open_main_page(String url){
        Configuration.timeout = 60000;
        Selenide.open(url);
        throw new io.cucumber.java.PendingException();

    }


}
