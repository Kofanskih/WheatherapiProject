package com.wheatherapi.service;

import com.wheatherapi.AssertableResponse;
import com.wheatherapi.models.queryParameters.CurrentWeatherRequest.CurrentWeatherQueryParams;
import io.restassured.response.Response;
import utils.GetApiKey;
import utils.GetMainURL;
import utils.GetPath;

import java.io.IOException;

public class CurrentService extends BaseService{

    public Response sendGetCurrentRequest(String path, String City, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get( String.format(new GetPath().takePath(path), City, new GetApiKey().takeApiKey(apiKey)));
    }

    public Response sendCurrentRequest1(String path, CurrentWeatherQueryParams currentWeatherQueryParams, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), currentWeatherQueryParams.getQ(), new GetApiKey().takeApiKey(apiKey)));

    }

    public AssertableResponse sendCurrentRequest2(String url, String path, CurrentWeatherQueryParams currentWeatherQueryParams, String apiKey) throws IOException {
        Response response =
                baseConfigurationRestAssuredCurrent(new GetMainURL().takeMainURL(url), new GetPath().takePath(path), currentWeatherQueryParams.getQ(), new GetApiKey().takeApiKey(apiKey))
                        .get().then().extract().response();
        return new AssertableResponse(response);
    }

    public AssertableResponse sendCurrentRequest3(String url, String path, CurrentWeatherQueryParams currentWeatherQueryParams) throws IOException {
        Response response =
                baseConfigurationRestAssuredCurrent(new GetMainURL().takeMainURL(url), new GetPath().takePath(path), currentWeatherQueryParams.getQ(), currentWeatherQueryParams.getKey())
                        .get().then().extract().response();
        return new AssertableResponse(response);
    }
}
