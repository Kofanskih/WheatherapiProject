package com.weatherapi.ui.tests;

import com.weatherapi.ui.pages.MainPage;
import com.weatherapi.ui.pages.TodayPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;

import java.io.IOException;

public class TodaysWeatherForecasTest {
    public final String textElementToday = "Today";

    @BeforeClass
    void preConditionsClass() {
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void preConditionsMethod() throws IOException {
        new MainPage().openHomePage();

    }

    @Test
    void userGoToTodayPageV1() {
        new TodayPage()
                .clickTodayButton()
                .checkTodayPageURL();

    }

    @Test
    void userGoToTodayPageV2() {
        new TodayPage()
                .clickTodayButton()
                .checkTodayPageElements(textElementToday);

    }

}
