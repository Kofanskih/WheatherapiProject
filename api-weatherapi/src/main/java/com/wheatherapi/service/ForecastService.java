package com.wheatherapi.service;

import io.restassured.response.Response;

public class ForecastService extends BaseService{
    private final String FORECAST_PATH = "/forecast.json?";
    private final String REQUIRED_Q = "q=";
    private final String REQUIRED_DAYS = "days=";
    private final String APIKEY = "key=";
    private final String VALUE_APIKEY = "ae34ceb905814b6bb0f215858252102";

    public Response sendForecastRequest(String City, int countDays){
        return baseConfigurationRestAssured()
                .get(FORECAST_PATH + REQUIRED_Q + City + "&" + REQUIRED_DAYS + countDays + "&" + APIKEY + VALUE_APIKEY);

    }

}
