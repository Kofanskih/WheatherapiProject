package com.weatherapi.ui.tests;

import com.weatherapi.ui.pages.TomorrowPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;

import static com.codeborne.selenide.Selenide.open;

public class TomorrowWeather {
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
    void userGoToTomorrowPageV1() {
        new TomorrowPage()
                .clickTommorrowButton()
                .checkTomorrowPageURL();

    }

    @Test
    void userGoToTomorrowPageV2() {
        new TomorrowPage()
                .clickTommorrowButton()
                .checkTomorrowPageElements();

    }
}
