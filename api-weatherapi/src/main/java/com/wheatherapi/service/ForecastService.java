package com.wheatherapi.service;

import com.wheatherapi.AssertableResponse;
import com.wheatherapi.models.queryParameters.ForecastWeatherRequest.ForecastWeatherQueryParams;
import io.restassured.response.Response;
import utils.GetPath;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ForecastService extends BaseService{
    private final String FORECAST_PATH = "/forecast.json?q=%s&days=%s";
    private final String REQUIRED_Q = "q";
    private final String DAYS = "days";

    public Response sendForecastRequest(String path, String City, int countDays) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), City, countDays));

    }

    public Response sendForecastRequest1(ForecastWeatherQueryParams forecastWeatherQueryParams) throws IOException{
        return baseConfigurationRestAssured()
                .get(String.format(FORECAST_PATH, forecastWeatherQueryParams.getQ(), forecastWeatherQueryParams.getDays()));

    }

    public Response sendForecastRequest2(String path, ForecastWeatherQueryParams forecastWeatherQueryParams) throws IOException{
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), forecastWeatherQueryParams.getQ(), forecastWeatherQueryParams.getDays()));

    }

    public AssertableResponse sendForecastRequest3(ForecastWeatherQueryParams forecastWeatherQueryParams) throws IOException{
        Response response = baseConfigurationRestAssured()
                .basePath(FORECAST_PATH)
                .params(REQUIRED_Q,forecastWeatherQueryParams.getQ(), DAYS, forecastWeatherQueryParams.getDays())
                .when()
                .get().then().extract().response();
        return new AssertableResponse(response);

    }

    public AssertableResponse sendForecastRequest4(ForecastWeatherQueryParams forecastWeatherQueryParams) throws IOException{
        Response response = baseConfigurationRestAssured().queryParams(REQUIRED_Q, forecastWeatherQueryParams.getQ(), DAYS, forecastWeatherQueryParams.getDays())
                .get(FORECAST_PATH).then().extract().response();
        return new AssertableResponse(response);

    }



}
