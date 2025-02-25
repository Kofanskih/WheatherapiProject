package com.weatherapi.ui.tests;

import com.weatherapi.ui.pageModels.MainPageModel;
import com.weatherapi.ui.pages.HistoryPage;

import com.weatherapi.ui.pages.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;


public class HistoryWeather {

    @BeforeClass
    void preConditionsClass() {
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void preConditionsMethod(){
        new MainPage().openMainPage(new MainPageModel().mainPageURL());

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
