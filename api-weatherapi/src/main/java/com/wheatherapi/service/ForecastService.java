package com.wheatherapi.service;

import io.restassured.response.Response;
import utils.GetApiKey;
import utils.GetPath;

import java.io.IOException;

public class ForecastService extends BaseService{
    private final String FORECAST_PATH = "/forecast.json?q=%s&days=%s&key=%s";


    public Response sendForecastRequest(String path, String City, int countDays, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), City, countDays, new GetApiKey().takeApiKey(apiKey)));

    }



}
