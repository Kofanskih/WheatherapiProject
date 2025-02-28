package com.wheatherapi.service;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {
    private final String MAIN_URL = "https://api.weatherapi.com/v1";
    private final String FUTURE_PATH = "/future.json?";
    private final String REQUIRED_Q = "q";
    private final String REQUIRED_DATA = "dt";
    private final String APIKEY = "key";

    protected RequestSpecification baseConfigurationRestAssured(){
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(MAIN_URL)
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;

    }

    protected RequestSpecification baseConfigurationRestAssuredFut(String q, String apiKey, String data){
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(MAIN_URL).basePath(FUTURE_PATH).param(REQUIRED_Q, q).param(APIKEY, apiKey).param(REQUIRED_DATA, data)
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;

    }

}
