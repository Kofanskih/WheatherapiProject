package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static utils.OwnerReadUrl.ownerMainUrl;
import static utils.ReadPropertyURL.getMainUrlProperty;

public class MainPage {
    private final SelenideElement loginPage = $("[class=\"nav-link\"][href=\"/login.aspx\"]");

    public MainPage open() throws IOException {
        Selenide.open(getMainUrlProperty());
        return new MainPage();
    }

    public MainPage open1(){
        Selenide.open(ownerMainUrl());
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
