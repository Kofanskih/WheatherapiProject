package com.weatherapi.ui.tests;

import com.weatherapi.ui.pageModels.LoginUserPageModel;
import com.weatherapi.ui.pages.LoginPage;
import com.weatherapi.ui.pages.MainPage;
import com.weatherapi.ui.pages.PersonalPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurateBrowserSettings;
import static com.codeborne.selenide.Selenide.open;

public class LoginWeatherapiTest {
    private final String MAIN_PAGE = "https://www.weatherapi.com/weather/";
    private final String personalAccountText = "Welcome Back\n";
    private final String WARNING_MESSAGE= "Your login attempt was not successful. Please try again.";



    @BeforeClass
    void preConditionsClass() {
        new ConfigurateBrowserSettings().setUp();
    }

    @BeforeMethod
    void preConditionsMethod(){
        open(MAIN_PAGE);

    }

    @Test
    void userLogin() {
        new MainPage()
                .goToLoginPage()
                .fillLoginDataWithUserModel(new LoginUserPageModel().userLogin());
        new PersonalPage().userShouldHaveExactTextOnTheAccountPage(personalAccountText);

    }

    @Test
    void userLoginWithWrongEmail(){
        new MainPage()
                .goToLoginPage()
                .fillLoginFormWithWrongEmail(new LoginUserPageModel().userLoginWithWrongEmail());
        new LoginPage().checkWarningLoginMessage(WARNING_MESSAGE);

    }

    @Test
    void userLoginWithWrongPassword(){
        new MainPage()
                .goToLoginPage()
                .fillLoginFormWithWrongPassword(new LoginUserPageModel().userLoginWithWrongPassword());
        new LoginPage().checkWarningLoginMessage(WARNING_MESSAGE);

    }
}
