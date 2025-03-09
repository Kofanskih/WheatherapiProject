package com.wheatherapi.service;

import io.restassured.response.Response;
import utils.GetApiKey;
import utils.GetPath;

import java.io.IOException;

public class CurrentService extends BaseService{

    public Response sendGetCurrentRequest(String path, String City, String apiKey) throws IOException {
        return baseConfigurationRestAssured()
                .get( String.format(new GetPath().takePath(path), City, new GetApiKey().takeApiKey(apiKey)));
    }
}
