package com.wheatherapi.service;

import io.restassured.response.Response;

public class CurrentService extends BaseService{
    private final String GET_PATH = "/current.json?";
    private final String REQUIRED_Q = "q=";
    private final String APIKEY = "key=";
    private final String VALUE_APIKEY = "ae34ceb905814b6bb0f215858252102";

    public Response sendGetCurrentRequest(String City){
        return baseConfigurationRestAssured()
                .get( GET_PATH + REQUIRED_Q + City + "&" + APIKEY + VALUE_APIKEY);
    }
}
