package com.weatherapi.ui.tests;

import com.weatherapi.ui.pageModels.MainPageModel;
import com.weatherapi.ui.pages.MainPage;
import com.weatherapi.ui.pages.TomorrowPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;

import java.io.IOException;


public class TomorrowWeather {
    public final String textElementTomorrow = "Tomorrow";

    @BeforeClass
    void preConditionsClass() {
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void preConditionsMethod() throws IOException {
        new MainPage().openMainPage();

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
                .checkTomorrowPageElements(textElementTomorrow);

    }
}
