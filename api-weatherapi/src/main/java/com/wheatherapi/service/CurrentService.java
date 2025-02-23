package com.wheatherapi.service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CurrentService extends BaseService{
    private final String GET_PATH = "/current.json?";
    private final String REQUIRED_Q = "q=";
    private final String REQUIRED_Q_VALUE = "Benidorm";
    private final String REQUIRED_APIKEY = "key=";
    private final String REQUIRED_VALUE_APIKEY = "ae34ceb905814b6bb0f215858252102";

    public Response sendGetCurrentRequest(){
        return baseConfigurationRestAssured()
                .get( GET_PATH + REQUIRED_Q + REQUIRED_Q_VALUE + "&" + REQUIRED_APIKEY + REQUIRED_VALUE_APIKEY);
    }
}
