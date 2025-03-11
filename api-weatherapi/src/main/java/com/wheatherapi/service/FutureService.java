package com.wheatherapi.service;

import com.wheatherapi.AssertableResponse;
import com.wheatherapi.models.queryParameters.FutureWeatherRequest.FutureWeatherQueryParams;
import io.restassured.response.Response;
import utils.GetApiKey;
import utils.GetPath;

import java.io.IOException;

public class FutureService extends BaseService{
    private final String FUTURE_PATH = "/future.json?q=%s&dt=%s&key=%s";

    public Response sendFutureRequest(String path, String City, String data, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), City, data, new GetApiKey().takeApiKey(apiKey)));

    }

    public Response sendFutureRequest2(FutureWeatherQueryParams futureWeatherQueryParams) throws IOException {
        return baseConfigurationRestAssuredFuture(futureWeatherQueryParams.getQ(), futureWeatherQueryParams.getKey(), futureWeatherQueryParams.getDt())
                .get();

    }

    public AssertableResponse sendFutureRequest3(FutureWeatherQueryParams futureWeatherQueryParams) throws IOException {
        Response response = baseConfigurationRestAssuredFuture(futureWeatherQueryParams.getQ(), futureWeatherQueryParams.getKey(), futureWeatherQueryParams.getDt())
                .get().then().extract().response();

        return new AssertableResponse(response);

    }

    public Response sendFutureRequest4(String City, String data, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(FUTURE_PATH, City, data, new GetApiKey().takeApiKey(apiKey)));

    }

}
