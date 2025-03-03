package com.weatherapi.ui.tests;

import com.weatherapi.ui.pageModels.LoginUserPageModel;
import com.weatherapi.ui.pageModels.MainPageModel;
import com.weatherapi.ui.pages.MainPage;
import com.weatherapi.ui.pages.PersonalPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;

public class LogoutTest {
    public final String loginButton = "Login";

    @BeforeClass
    void preConditions() {
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void userLogin() {
        new MainPage()
                .openMainPage(new MainPageModel().mainPageURL())
                .goToLoginPage()
                .fillLoginDataWithUserModel(new LoginUserPageModel().userLogin());

    }

    @Test
    void userBookShopLogout() {
        new PersonalPage()
                .logout()
                .checkUserLogout(loginButton);

    }
}
