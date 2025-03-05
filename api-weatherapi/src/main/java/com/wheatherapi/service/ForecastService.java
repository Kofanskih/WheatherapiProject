package com.wheatherapi.service;

import io.restassured.response.Response;

public class ForecastService extends BaseService{
    private final String VALUE_APIKEY = "ae34ceb905814b6bb0f215858252102";
    private final String FORECAST_PATH = "/forecast.json?q=%s&days=%s&key=%s";


    public Response sendForecastRequest(String City, int countDays){
        return baseConfigurationRestAssured()
                .get(String.format(FORECAST_PATH, City, countDays, VALUE_APIKEY));

    }



}
