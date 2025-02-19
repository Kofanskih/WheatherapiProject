package com.wheatherapi.ui.tests;

import com.wheatherapi.ui.pages.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;

public class TodaysWeatherForecasTest {
    private final String MAIN_PAGE = "https://www.weatherapi.com/weather/";

    @BeforeClass
    void preConditions() {
        new ConfigurateBrowserSettings().setUp();
    }

    @Test
    void userBookShopLogin() {
        new MainPage(MAIN_PAGE);

    }




}
