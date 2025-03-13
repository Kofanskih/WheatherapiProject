package com.wheatherapi.service;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.GetMainURL;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class BaseService {
    private final String FUTURE_PATH = "/future.json?";
    private final String REQUIRED_Q = "q";
    private final String REQUIRED_DATA = "dt";
    private final String APIKEY = "key";

    protected RequestSpecification baseConfigurationRestAssured() throws IOException {
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(new GetMainURL().takeMainURL("main_url"))
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;

    }

    protected RequestSpecification baseConfigurationRestAssuredFuture(String q, String apiKey, String data) throws IOException {
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(new GetMainURL().takeMainURL("main_url"))
                .basePath(FUTURE_PATH)
                .params(REQUIRED_Q, q, APIKEY, apiKey, REQUIRED_DATA, data)
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;

    }


}
