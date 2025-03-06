package com.wheatherapi.service;

import com.wheatherapi.AssertableResponse;
import com.wheatherapi.models.queryParameters.FutureWeatherRequest.FutureWeatherQueryParams;
import io.restassured.response.Response;

public class FutureService extends BaseService{
    private final String FUTURE_PATH = "/future.json?q=%s&dt=%s&key=%s";
    private final String VALUE_APIKEY = "ae34ceb905814b6bb0f215858252102";

    public Response sendFutureRequest(String City, String data){
        return baseConfigurationRestAssured()
                .get(String.format(FUTURE_PATH, City, data, VALUE_APIKEY));

    }

    public Response sendFutureRequest2(FutureWeatherQueryParams futureWeatherQueryParams){
        return baseConfigurationRestAssuredFut(futureWeatherQueryParams.getQ(), futureWeatherQueryParams.getKey(), futureWeatherQueryParams.getDt())
                .get();

    }

    public AssertableResponse sendFutureRequest3(FutureWeatherQueryParams futureWeatherQueryParams){
        Response response =  baseConfigurationRestAssuredFut(futureWeatherQueryParams.getQ(), futureWeatherQueryParams.getKey(), futureWeatherQueryParams.getDt())
                .get().then().extract().response();

        return new AssertableResponse(response);

    }

}
