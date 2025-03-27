package com.weatherapi.ui.tests;

import com.codeborne.selenide.Selenide;
import com.weatherapi.ui.pageModels.LoginUserPageModel;
import com.weatherapi.ui.pages.LoginPage;
import com.weatherapi.ui.pages.MainPage;
import com.weatherapi.ui.pages.PersonalPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;
import utils.ReadPropertyURL;

import java.io.IOException;

public class LoginWeatherapiTest {
    private final String personalAccountText = "Welcome Back\n";
    private final String WARNING_MESSAGE= "Your login attempt was not successful. Please try again.";

    @BeforeClass
    void preConditionsClass() {
        new ConfigurateBrowserSettings().setUpRemoteServer();
    }

    @BeforeMethod
    void preConditionsMethod() throws IOException {
        new MainPage().open();

    }

    @Test
    void userLogin() {
        new MainPage()
                .goToLoginPage()
                .fillLoginDataWithUserModel(new LoginUserPageModel().userLogin());
        new PersonalPage().userShouldHaveExactTextOnTheAccountPage(personalAccountText);
        Selenide.sleep(5000);

    }

    @Test
    void userLoginWithWrongPassword() {
        new MainPage()
                .goToLoginPage()
                .fillLoginDataWithUserModel(new LoginUserPageModel().userLoginWithWrongPassword());
        new LoginPage().checkWarningLoginMessage(WARNING_MESSAGE);
        Selenide.sleep(5000);

    }

    @Test
    void userLoginWithWrongEmail(){
        new MainPage()
                .goToLoginPage()
                .fillLoginDataWithUserModel(new LoginUserPageModel().userLoginWithWrongEmail());
        new LoginPage().checkWarningLoginMessage(WARNING_MESSAGE);
        Selenide.sleep(5000);

    }

}
