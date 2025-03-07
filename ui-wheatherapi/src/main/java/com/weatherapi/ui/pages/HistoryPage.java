package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class HistoryPage {
    private final SelenideElement historyButton = $("[class=\"p-2\"][href=\"/history/q/benidorm-699566\"]");
    private final String historyURL = "https://www.weatherapi.com/history/q/benidorm-699566";
    private final SelenideElement historyElement = $("[class=\"p-2 h4\"][title=\"Benidorm weather history\"]");
    private final SelenideElement pressureThirdElementInTable = $x("//main//tbody/tr[7]/td[5][@style=\"background-color:#C6F56F;\"]");
    private final ElementsCollection tableWeatherIn = $$(By.tagName("td"));
    private final String windElementInTheTableWeatherIn = tableWeatherIn.get(22).getText();
    private final String hourElementInTheTableAnnualWeatherAverages = tableWeatherIn.get(115).getText();



    public HistoryPage clickHistoryButton(){
        historyButton.click();
        return new HistoryPage();
    }

    public HistoryPage checkHistoryPageURL(){
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), historyURL);
        return this;
    }

    public HistoryPage checkHistoryPageElements(String textElementHistory){
        historyElement.shouldHave(Condition.exactText(textElementHistory));
        return this;
    }

    public HistoryPage checkPressureData(String pressureElement){
        pressureThirdElementInTable.shouldHave(Condition.partialText(pressureElement));
        return this;
    }

    public HistoryPage checkWindElementInHistoryTable(String windElement){
        Assert.assertTrue(windElementInTheTableWeatherIn.endsWith(windElement));
        return this;
    }

    public HistoryPage checkHoursElementInHistoryTable(String hourElement){
        Assert.assertTrue(hourElementInTheTableAnnualWeatherAverages.endsWith(hourElement));
        return this;
    }


}
