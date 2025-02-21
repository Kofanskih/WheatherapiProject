package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class TomorrowPage {
    private final SelenideElement tomorrowButton = $("[class=\"p-2\"][title=\"Tomorrow weather\"]");
    private final String tomorrowURL = "https://www.weatherapi.com/weather/q/benidorm-699566?day=1";
    private final SelenideElement tomorrowElement = $("[href=\"/weather/q/benidorm-699566?day=1\"][title=\"Tomorrow weather\"]");
    public final String textElementTomorrow = "Tomorrow";

    public TomorrowPage clickTommorrowButton(){
        tomorrowButton.click();
        return new TomorrowPage();
    }

    public TomorrowPage checkTomorrowPageURL(){
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), tomorrowURL);
        return this;
    }

    public TomorrowPage checkTomorrowPageElements(){
        tomorrowElement.shouldHave(Condition.exactText(textElementTomorrow));
        return this;
    }
}
