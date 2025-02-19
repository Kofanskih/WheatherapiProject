package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class HistoryPage {
    private final SelenideElement historyButton = $("[class=\"p-2\"][title=\"Benidorm weather history\"]");
    private final String historyURL = "https://www.weatherapi.com/history/q/benidorm-699566";
    private final SelenideElement historyElement = $("[class=\"p-2 h4\"][title=\"Benidorm weather history\"]");
    public final String textElementHistory = "History";

    public HistoryPage goToTomorrowPage(){
        historyButton.click();
        return new HistoryPage();
    }

    public HistoryPage checkTomorrowPageURL(){
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), historyURL);
        return this;
    }

    public HistoryPage checkTomorrowPageElements(){
        historyElement.shouldHave(Condition.exactText(textElementHistory));
        return this;
    }
}
