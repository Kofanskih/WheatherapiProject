package com.weatherapi.ui.tests;

import com.weatherapi.ui.pages.MainPage;
import com.weatherapi.ui.pages.TodayPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;

public class TodaysWeatherForecasTest {
    private final String MAIN_PAGE = "https://www.weatherapi.com/weather/";

    @BeforeClass
    void preConditionsClass() {
        new ConfigurateBrowserSettings().setUp();
    }
    @BeforeMethod
    void preConditionsMethod(){
        new MainPage(MAIN_PAGE);
    }

    @Test
    void userGoToTodayPageV1() {
        new TodayPage()
                .goToTodayPage()
                .checkTodayPageURL();

    }

    @Test
    void userGoToTodayPageV2() {
        new TodayPage()
                .goToTodayPage()
                .checkTodayPageElements();

    }




}
