package com.wheatherapi.service;

import com.wheatherapi.AssertableResponse;
import com.wheatherapi.models.queryParameters.MarineWeatherRequest.MarineWeatherQueryParams;
import io.restassured.response.Response;
import utils.GetPath;

import java.io.IOException;

public class MarineService extends BaseService{
    private final String MARINE_PATH = "/marine.json?q=%s&days=%s";
    private final String REQUIRED_Q = "q";
    private final String DAYS = "days";

    public Response sendMarineRequest(String path, String City, int countDays) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), City, countDays));

    }

    public Response sendMarineRequest2(String path, MarineWeatherQueryParams marineWeatherQueryParams) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), marineWeatherQueryParams.getQ(), marineWeatherQueryParams.getDays()));

    }

    public AssertableResponse sendMarineRequest3(MarineWeatherQueryParams marineWeatherQueryParams) throws IOException {
        Response response =
                baseConfigurationRestAssured()
                        .queryParams(REQUIRED_Q, marineWeatherQueryParams.getQ(), DAYS, marineWeatherQueryParams.getDays())
                .get(MARINE_PATH).then().extract().response();

        return new AssertableResponse(response);

    }

    public Response sendMarineRequest4(String City, int countDays) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(MARINE_PATH, City, countDays));

    }

}
