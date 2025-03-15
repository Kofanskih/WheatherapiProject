package com.weatherapi.ui.pageModels;

import lombok.Data;

@Data
public class MainPageModel {
    private String MAIN_PAGE;

    public MainPageModel mainPageURL(){
        this.MAIN_PAGE = "https://www.weatherapi.com/weather/";
        return this;
    }
}
