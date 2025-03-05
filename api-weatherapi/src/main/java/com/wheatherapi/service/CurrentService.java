package com.wheatherapi.service;

import io.restassured.response.Response;

public class CurrentService extends BaseService{

    private final String CURRENT_PATH = "/current.json?q=%s&key=%s";;
    private final String VALUE_APIKEY = "ae34ceb905814b6bb0f215858252102";

    public Response sendGetCurrentRequest(String City){
        return baseConfigurationRestAssured()
                .get( String.format(CURRENT_PATH, City, VALUE_APIKEY));
    }
}
