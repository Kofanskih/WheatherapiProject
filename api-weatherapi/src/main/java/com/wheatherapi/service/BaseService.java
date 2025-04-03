package com.wheatherapi.service;

import com.wheatherapi.encryption.Encryption;
import com.wheatherapi.encryption.Encryption.*;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import utils.GetApiKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


import static com.wheatherapi.encryption.Encryption.*;
import static io.restassured.RestAssured.given;
import static utils.GetMainURL.takeMainURL;

public class BaseService {

    protected RequestSpecification baseConfigurationRestAssured() throws IOException {
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(takeMainURL())
                .queryParam("key", new GetApiKey().takeApiKey("api_key"))
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;

    }


    protected RequestSpecification baseConfigurationRestAssured1() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        RequestSpecification reqSpec = given()
                .contentType(ContentType.JSON)
                .baseUri(takeMainURL())
                .queryParam("key", Encryption.decryptApi(decodeSecretKey("Cn7OdDjKr2iKA+ektLl9IA=="), "jUUbJH57p9Jo29a704qZY4Thp3xWbaBveAb0vYzxjlU="))
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        return reqSpec;

    }

}
