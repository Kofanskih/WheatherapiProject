package com.weatherapi.ui.pages;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    public MainPage(String mainPage){
        open(mainPage);

    }
}
