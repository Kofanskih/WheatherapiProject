package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("Open main page {string}")
    public void open_main_page(String url){
        Configuration.timeout = 60000;
        Selenide.open(url);

    }

}
