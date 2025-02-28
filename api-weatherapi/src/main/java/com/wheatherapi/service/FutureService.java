package com.wheatherapi.service;

import com.wheatherapi.models.queryParameters.FutureWeatherRequest.FutureWeatherQueryParams;
import io.restassured.response.Response;

public class FutureService extends BaseService{
    private final String FUTURE_PATH = "/future.json?";
    private final String REQUIRED_Q = "q";
    private final String REQUIRED_DATA = "dt";
    private final String APIKEY = "key";
    private final String VALUE_APIKEY = "ae34ceb905814b6bb0f215858252102";

    public Response sendFutureRequest(String City, String data){
        return baseConfigurationRestAssured()
                .get(FUTURE_PATH + REQUIRED_Q + "=" + City + "&" + REQUIRED_DATA + "=" + data + "&" + APIKEY + "=" + VALUE_APIKEY);

    }

    public Response sendFutureRequest2(FutureWeatherQueryParams futureWeatherQueryParams){
        return baseConfigurationRestAssuredFut(futureWeatherQueryParams.getQ(), futureWeatherQueryParams.getKey(), futureWeatherQueryParams.getDt())
                .get();

    }

}
