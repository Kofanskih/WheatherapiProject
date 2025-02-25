package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.weatherapi.ui.pageModels.LoginUserPageModel;
import com.weatherapi.ui.pageModels.MainPageModel;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final String MAIN_PAGE = "https://www.weatherapi.com/weather/";
    private final SelenideElement loginPage = $("[href=\"/login.aspx\"]");
    public final String loginButton = "Login";

    public MainPage openMainPage(MainPageModel mainPageModel) {

        Selenide.open(mainPageModel.getMAIN_PAGE());
        return this;
    }


    public LoginPage goToLoginPage(){
        loginPage.click();
        return new LoginPage();
    }

    public MainPage checkUserLogout(){
        loginPage.shouldHave(Condition.exactText(loginButton));
        return new MainPage();
    }
}
