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
    private final SelenideElement windElementInTheTableWeatherIn = tableWeatherIn.get(22);
    private final SelenideElement hourElementInTheTableAnnualWeatherAverages = tableWeatherIn.get(115);



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
        String actual = windElementInTheTableWeatherIn.getText();
        Assert.assertTrue(actual.endsWith(windElement));
        return this;
    }

    public HistoryPage checkHoursElementInHistoryTable(String hourElement){
        String actual = hourElementInTheTableAnnualWeatherAverages.getText();
        Assert.assertTrue(actual.endsWith(hourElement));
        return this;
    }


}
