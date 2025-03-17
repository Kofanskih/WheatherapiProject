package com.wheatherapi.service;

import com.wheatherapi.AssertableResponse;
import com.wheatherapi.models.queryParameters.ForecastWeatherRequest.ForecastWeatherQueryParams;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.GetApiKey;
import utils.GetPath;

import java.io.IOException;

public class ForecastService extends BaseService{
    private final String FORECAST_PATH = "/forecast.json?q=%s&days=%s&key=%s";
    private final String REQUIRED_Q = "q";
    private final String DAYS = "days";
    private final String APIKEY = "key";

//    public RequestSpecification baseConfigurationRestAssuredForecast(String q, int days, String apiKey) throws IOException {
//        return baseConfigurationRestAssured()
//                .basePath(FORECAST_PATH)
//                .params(REQUIRED_Q, q, DAYS, days, APIKEY, apiKey)
//                .when()
//                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
//    }


    public Response sendForecastRequest(String path, String City, int countDays, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), City, countDays, new GetApiKey().takeApiKey(apiKey)));

    }

    public Response sendForecastRequest1(ForecastWeatherQueryParams forecastWeatherQueryParams, String apiKey) throws IOException{
        return baseConfigurationRestAssured()
                .get(String.format(FORECAST_PATH, forecastWeatherQueryParams.getQ(), forecastWeatherQueryParams.getDays(), apiKey));

    }

    public Response sendForecastRequest2(String path, ForecastWeatherQueryParams forecastWeatherQueryParams, String apiKey) throws IOException{
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), forecastWeatherQueryParams.getQ(), forecastWeatherQueryParams.getDays(), apiKey));

    }

    public AssertableResponse sendForecastRequest3(ForecastWeatherQueryParams forecastWeatherQueryParams, String apiKey) throws IOException{
        Response response = baseConfigurationRestAssured()
                .basePath(FORECAST_PATH)
                .params(REQUIRED_Q,forecastWeatherQueryParams.getQ(), DAYS, forecastWeatherQueryParams.getDays(), APIKEY, new GetApiKey().takeApiKey(apiKey))
                .when()
                .get().then().extract().response();
        return new AssertableResponse(response);

    }

    public AssertableResponse sendForecastRequest4(ForecastWeatherQueryParams forecastWeatherQueryParams) throws IOException{
        Response response = baseConfigurationRestAssured().queryParams(REQUIRED_Q, forecastWeatherQueryParams.getQ(), forecastWeatherQueryParams.getDays(), forecastWeatherQueryParams.getKey())
                .get(FORECAST_PATH).then().extract().response();
        return new AssertableResponse(response);

    }



}
