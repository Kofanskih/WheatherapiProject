package com.wheatherapi.service;

import com.wheatherapi.AssertableResponse;
import com.wheatherapi.models.queryParameters.CurrentWeatherRequest.CurrentWeatherQueryParams;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import utils.GetPath;

import java.io.IOException;

public class CurrentService extends BaseService{
    private final String REQUIRED_Q = "q";
    private final String CURRENT_PATH = "/current.json?q=%s";


    public Response sendGetCurrentRequest(String City) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(CURRENT_PATH, City));
    }

    @SneakyThrows
    public Response sendGetCurrentRequest01(String City) throws IOException {
        return baseConfigurationRestAssured1()
                .get(String.format(CURRENT_PATH, City));
    }


    public Response sendCurrentRequest1(String path, CurrentWeatherQueryParams currentWeatherQueryParams) throws IOException {
        return baseConfigurationRestAssured()
                .get(String.format(new GetPath().takePath(path), currentWeatherQueryParams.getQ()));

    }

    public AssertableResponse sendCurrentRequest2(CurrentWeatherQueryParams currentWeatherQueryParams) throws IOException {
        Response response = baseConfigurationRestAssured()
                .basePath(CURRENT_PATH)
                .params(REQUIRED_Q, currentWeatherQueryParams.getQ())
                .when()
                .get().then().extract().response();
        return new AssertableResponse(response);
    }

    public AssertableResponse sendCurrentRequest3(CurrentWeatherQueryParams currentWeatherQueryParams) throws IOException {
        Response response =
                baseConfigurationRestAssured().queryParam(REQUIRED_Q, currentWeatherQueryParams.getQ())
                        .get(CURRENT_PATH).then().extract().response();
        return new AssertableResponse(response);
    }

}
