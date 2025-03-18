package com.wheatherapi.service;

import com.wheatherapi.AssertableResponse;
import com.wheatherapi.models.queryParameters.FutureWeatherRequest.FutureWeatherQueryParams;
import io.restassured.response.Response;
import utils.GetPath;

import java.io.IOException;

public class FutureService extends BaseService{
    private final String FUTURE_PATH = "/future.json?q=%s&dt=%s";
    private final String REQUIRED_Q = "q";
    private final String REQUIRED_DATA = "dt";

    public Response sendFutureRequest(String path, String City, String data) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), City, data));

    }

    public Response sendFutureRequest2(String path, FutureWeatherQueryParams futureWeatherQueryParams) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path),futureWeatherQueryParams.getQ(), futureWeatherQueryParams.getDt()));

    }

    public AssertableResponse sendFutureRequest3(FutureWeatherQueryParams futureWeatherQueryParams) throws IOException {
        Response response =
                baseConfigurationRestAssured()
                        .queryParams(REQUIRED_Q, futureWeatherQueryParams.getQ(), REQUIRED_DATA, futureWeatherQueryParams.getDt())
                .get(FUTURE_PATH).then().extract().response();

        return new AssertableResponse(response);

    }

    public Response sendFutureRequest4(String City, String data) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(FUTURE_PATH, City, data));

    }

}
