package com.wheatherapi.service;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.GetMainURL;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class BaseService {

    protected RequestSpecification baseConfigurationRestAssured() throws IOException {
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(new GetMainURL().takeMainURL("main_url"))
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;

    }
}
