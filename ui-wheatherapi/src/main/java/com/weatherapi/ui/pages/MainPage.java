package com.weatherapi.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.weatherapi.ui.pageModels.MainPageModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement loginPage = $("[href=\"/login.aspx\"]");

    public MainPage openMainPage(MainPageModel mainPageModel) {
        Selenide.open(mainPageModel.getMAIN_PAGE());
        return this;
    }


    public Properties openHomePage() throws IOException {
        Properties props = new Properties();
        InputStream input = new FileInputStream("src/main/resources/urls.properties");
        props.load(input);
        open(props.getProperty("main_url"));
        return props;
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
