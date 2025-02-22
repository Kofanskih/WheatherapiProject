package com.weatherapi.ui.tests;

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
    private final String USER_EMAIL = "kofanskih08@gmail.com";
    private final String USER_PASSWORD = "f2H*Jap*M6@7/d_";
    private final String personalAccountText = "Welcome Back\n";
    private final String WRONG_USER_EMAIL = "kofanski08@gmail.com";
    private final String WRONG_USER_PASSWORD = "09876TYUI54321i";
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
    void userLoginV1() {
        new MainPage()
                .goToLoginPage()
                .fillEmailField(USER_EMAIL)
                .fillPasswordField(USER_PASSWORD)
                .clickLoginButton();
        new PersonalPage().userShouldHaveExactTextOnTheAccountPage(personalAccountText);

    }

    @Test
    void userLoginV2() {
        new MainPage()
                .goToLoginPage()
                .fillLoginData(USER_EMAIL, USER_PASSWORD);
        new PersonalPage().userShouldHaveExactTextOnTheAccountPage(personalAccountText);

    }

    @Test
    void userLoginWithWrongEmail(){
        new MainPage()
                .goToLoginPage()
                .fillLoginFormWithWrongEmail(WRONG_USER_EMAIL, USER_PASSWORD);

        new LoginPage().checkWarningLoginMessage(WARNING_MESSAGE);

    }

    @Test
    void userLoginWithWrongPassword(){
        new MainPage()
                .goToLoginPage()
                .fillLoginFormWithWrongPassword(USER_EMAIL, WRONG_USER_PASSWORD);

        new LoginPage().checkWarningLoginMessage(WARNING_MESSAGE);

    }
}
