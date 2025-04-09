package weatherapi;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;


public class StepWeatherapi {
    private final SelenideElement todayButton = $("[class=\"p-2 h4\"][title=\"Today weather\"]");
    private final String todayURL = "https://www.weatherapi.com/weather/q/benidorm-699566";
    private final SelenideElement todayElement = $("[href=\"/weather/q/benidorm-699566\"][title=\"Today weather\"]");


    @When("User click to Today button")
    public void clickTodayButton(){
        todayButton.click();

    }

    @Then("User is on the Today page")
    public void checkTodayPageURL(){
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), todayURL);
    }

    @And("Current weather is displayed")
    public void checkTodayPageElements(String textElementToday){
        todayElement.shouldHave(Condition.exactText(textElementToday));
    }
}
