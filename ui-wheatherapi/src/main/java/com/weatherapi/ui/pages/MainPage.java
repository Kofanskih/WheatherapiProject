package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.weatherapi.ui.pageModels.MainPageModel;
import utils.OpenMainPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement loginPage = $("[class=\"nav-link\"][href=\"/login.aspx\"]");

    public MainPage openMainPage(MainPageModel mainPageModel) {
        Selenide.open(mainPageModel.getMAIN_PAGE());
        return this;
    }


    public MainPage openHomePage(String keyProperty) throws IOException {
        new OpenMainPage().takeUrl(keyProperty);
        return new MainPage();
    }

    public LoginPage goToLoginPage(){
        loginPage.click();
        return new LoginPage();
    }

    public MainPage checkUserLogout(String loginButton){
        loginPage.shouldHave(Condition.exactText(loginButton));
        return new MainPage();
    }
}
