package com.weatherapi.ui.tests;

import com.weatherapi.ui.pageModels.LoginUserPageModel;
import com.weatherapi.ui.pages.MainPage;
import com.weatherapi.ui.pages.PersonalPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;
import static com.codeborne.selenide.Selenide.open;


public class LogoutTest {
    private final String MAIN_PAGE = "https://www.weatherapi.com/";

    @BeforeClass
    void preConditions() {
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void userLogin() {
        open(MAIN_PAGE);
        new MainPage()
                .goToLoginPage()
                .fillLoginDataWithUserModel(new LoginUserPageModel().userLogin());

    }

    @Test
    void userBookShopLogout() {
        new PersonalPage()
                .logout()
                .checkUserLogout();

    }
}
