package com.wheatherapi.service;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {
    private final String MAIN_URL = "https://api.weatherapi.com/v1";

    protected RequestSpecification baseConfigurationRestAssured(){
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(MAIN_URL)
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;

    }

}
