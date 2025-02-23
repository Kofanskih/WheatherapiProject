package com.wheatherapi.service;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {
    private final String MAIN_URL = "https://api.weatherapi.com/v1";
    private final String GET_PATH = "/current.json?";
    private final String REQUIRED_Q = "q=";
    private final String REQUIRED_Q_VALUE = "Benidorm";
    private final String REQUIRED_APIKEY = "key=";
    private final String REQUIRED_VALUE_APIKEY = "ae34ceb905814b6bb0f215858252102";
    protected RequestSpecification baseConfigurationRestAssured(){
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(MAIN_URL)
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;

    }

}
