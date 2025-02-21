package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HistoryPage {
    private final SelenideElement historyButton = $("[class=\"p-2\"][title=\"Benidorm weather history\"]");
    private final String historyURL = "https://www.weatherapi.com/history/q/benidorm-699566";
    private final SelenideElement historyElement = $("[class=\"p-2 h4\"][title=\"Benidorm weather history\"]");
    private final String textElementHistory = "History";
    private final SelenideElement pressureThirdElementInTable = $x("//main//tbody/tr[7]/td[5][@style=\"background-color:#C6F56F;\"]");
    private final String pressureElement = "mb";

    public HistoryPage clickHistoryButton(){
        historyButton.click();
        return new HistoryPage();
    }

    public HistoryPage checkHistoryPageURL(){
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), historyURL);
        return this;
    }

    public HistoryPage checkHistoryPageElements(){
        historyElement.shouldHave(Condition.exactText(textElementHistory));
        return this;
    }

    public HistoryPage checkPressureData(){
        pressureThirdElementInTable.shouldHave(Condition.partialText(pressureElement));
        return this;
    }


}
