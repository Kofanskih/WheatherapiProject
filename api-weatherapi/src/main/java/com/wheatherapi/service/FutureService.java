package com.wheatherapi.service;

import com.wheatherapi.AssertableResponse;
import com.wheatherapi.models.queryParameters.FutureWeatherRequest.FutureWeatherQueryParams;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.GetApiKey;
import utils.GetPath;

import java.io.IOException;

public class FutureService extends BaseService{
    private final String FUTURE_PATH = "/future.json?q=%s&dt=%s&key=%s";
    private final String REQUIRED_Q = "q";
    private final String REQUIRED_DATA = "dt";
    private final String APIKEY = "key";

    protected RequestSpecification baseConfigurationRestAssuredFuture(String q, String data, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .basePath(FUTURE_PATH)
                .params(REQUIRED_Q, q, REQUIRED_DATA, data, APIKEY, apiKey)
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    }

    public Response sendFutureRequest(String path, String City, String data, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), City, data, new GetApiKey().takeApiKey(apiKey)));

    }

    public Response sendFutureRequest2(String path, FutureWeatherQueryParams futureWeatherQueryParams, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path),futureWeatherQueryParams.getQ(), futureWeatherQueryParams.getDt(), new GetApiKey().takeApiKey(apiKey)));

    }

    public AssertableResponse sendFutureRequest3(FutureWeatherQueryParams futureWeatherQueryParams) throws IOException {
        Response response = baseConfigurationRestAssuredFuture(futureWeatherQueryParams.getQ(), futureWeatherQueryParams.getDt(), futureWeatherQueryParams.getKey())
                .get().then().extract().response();

        return new AssertableResponse(response);

    }

    public Response sendFutureRequest4(String City, String data, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(FUTURE_PATH, City, data, new GetApiKey().takeApiKey(apiKey)));

    }

}
