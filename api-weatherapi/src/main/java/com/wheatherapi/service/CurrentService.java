package com.wheatherapi.service;

import io.restassured.response.Response;
import utils.GetApiKey;

import java.io.IOException;

public class CurrentService extends BaseService{
    private final String CURRENT_PATH = "/current.json?q=%s&key=%s";

    public Response sendGetCurrentRequest(String City, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get( String.format(CURRENT_PATH, City, new GetApiKey().takeApiKey(apiKey)));
    }
}
