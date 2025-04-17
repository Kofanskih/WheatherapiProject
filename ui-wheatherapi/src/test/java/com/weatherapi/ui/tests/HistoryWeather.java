package com.weatherapi.ui.tests;

import com.weatherapi.ui.pages.HistoryPage;

import com.weatherapi.ui.pages.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;

import java.io.IOException;



public class HistoryWeather {
    private final String textElementHistory = "History";
    private final String pressureElement = "mb";
    private final String windElement = "kmph";
    private final String hourElement = "hours";

    @BeforeClass
    void preConditionsClass() {
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void preConditionsMethod() throws IOException {
        new MainPage().open();

    }

    @Test
    void userGoToHistoryPageV1() {
        new HistoryPage()
                .clickHistoryButton()
                .checkHistoryPageURL();

    }

    @Test
    void userGoToHistoryPageV2() {
        new HistoryPage()
                .clickHistoryButton()
                .checkHistoryPageElements(textElementHistory);

    }

    @Test
    void verifyPressureElementInTheHistoryTable(){
        new HistoryPage()
                .clickHistoryButton()
                .checkPressureData(pressureElement);
    }

    @Test
    void checkElementInTable(){
        new HistoryPage()
                .clickHistoryButton()
                .checkWindElementInHistoryTable(windElement);

    }

    @Test
    void checkHoursElementInWeatherAveragesTable(){
        new HistoryPage()
                .clickHistoryButton()
                .checkHoursElementInHistoryTable(hourElement);

    }

}
