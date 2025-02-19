package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import static com.codeborne.selenide.Selenide.$;

public class TodayPage {
    private final SelenideElement todayButton = $("[class=\"p-2 h4\"][title=\"Today weather\"]");
    private final String todayURL = "https://www.weatherapi.com/weather/q/benidorm-699566";
    private final SelenideElement todayElement = $("[href=\"/weather/q/benidorm-699566\"][title=\"Today weather\"]");
    public final String textElementToday = "Today";

    public TodayPage goToTodayPage(){
        todayButton.click();
        return new TodayPage();
    }

    public TodayPage checkTodayPageURL(){
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), todayURL);
        return this;
    }

    public TodayPage checkTodayPageElements(){
        todayElement.shouldHave(Condition.exactText(textElementToday));
        return this;
    }

}
