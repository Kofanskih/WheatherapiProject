package com.weatherapi.ui.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final String MAIN_PAGE = "https://www.weatherapi.com/weather/";

    public  MainPage open() {
        Selenide.open(MAIN_PAGE);
        return new MainPage();
    }
}
