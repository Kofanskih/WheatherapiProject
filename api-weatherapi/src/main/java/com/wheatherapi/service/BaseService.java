package com.wheatherapi.service;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.GetApiKey;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utils.GetMainURL.takeMainURL;

public class BaseService {


    protected RequestSpecification baseConfigurationRestAssured() throws IOException {
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(takeMainURL())
                .queryParam("key",new GetApiKey().takeApiKey("api_key"))
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;

    }
}
