package com.weatherapi.ui.tests;

import com.weatherapi.ui.pages.HistoryPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;

import static com.codeborne.selenide.Selenide.open;

public class HistoryWeather {
    private final String MAIN_PAGE = "https://www.weatherapi.com/weather/";


    @BeforeClass
    void preConditionsClass() {
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void preConditionsMethod(){
        open(MAIN_PAGE);

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
                .checkHistoryPageElements();

    }

    @Test
    void verifyPressureElementInTheHistoryTable(){
        new HistoryPage()
                .clickHistoryButton()
                .checkPressureData();
    }

    @Test
    void checkElementInTable(){
        new HistoryPage()
                .clickHistoryButton()
                .checkWindElementInHistoryTable();

    }

    @Test
    void checkHoursElementInWeatherAveragesTable(){
        new HistoryPage()
                .clickHistoryButton()
                .checkHoursElementInHistoryTable();

    }

}
