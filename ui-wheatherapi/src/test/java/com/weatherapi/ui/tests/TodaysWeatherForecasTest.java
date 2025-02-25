package com.weatherapi.ui.tests;

import com.weatherapi.ui.pageModels.MainPageModel;
import com.weatherapi.ui.pages.MainPage;
import com.weatherapi.ui.pages.TodayPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;

public class TodaysWeatherForecasTest {

    @BeforeClass
    void preConditionsClass() {
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void preConditionsMethod(){
        new MainPage().openMainPage(new MainPageModel().mainPageURL());

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
                .checkTodayPageElements();

    }

}
