package com.wheatherapi.service;

import com.wheatherapi.AssertableResponse;
import com.wheatherapi.models.queryParameters.CurrentWeatherRequest.CurrentWeatherQueryParams;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.GetApiKey;
import utils.GetPath;

import java.io.IOException;


public class CurrentService extends BaseService{
    private final String REQUIRED_Q = "q";
    private final String APIKEY = "key";

    protected RequestSpecification baseConfigurationRestAssuredCurrent(String path, String q, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .basePath(path)
                .params(REQUIRED_Q, q, APIKEY, apiKey)
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    }

    public Response sendGetCurrentRequest(String path, String City, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get( String.format(new GetPath().takePath(path), City, new GetApiKey().takeApiKey(apiKey)));
    }

    public Response sendCurrentRequest1(String path, CurrentWeatherQueryParams currentWeatherQueryParams, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), currentWeatherQueryParams.getQ(), new GetApiKey().takeApiKey(apiKey)));

    }

    public AssertableResponse sendCurrentRequest2(String path, CurrentWeatherQueryParams currentWeatherQueryParams, String apiKey) throws IOException {
        Response response = baseConfigurationRestAssured()
                .basePath(new GetPath().takePath(path))
                .params(REQUIRED_Q, currentWeatherQueryParams.getQ(), APIKEY, new GetApiKey().takeApiKey(apiKey))
                .when()
                .get().then().extract().response();
        return new AssertableResponse(response);
    }

    public AssertableResponse sendCurrentRequest3( String path, CurrentWeatherQueryParams currentWeatherQueryParams) throws IOException {
        Response response =
                baseConfigurationRestAssuredCurrent(new GetPath().takePath(path), currentWeatherQueryParams.getQ(), currentWeatherQueryParams.getKey())
                        .get().then().extract().response();
        return new AssertableResponse(response);
    }

}
