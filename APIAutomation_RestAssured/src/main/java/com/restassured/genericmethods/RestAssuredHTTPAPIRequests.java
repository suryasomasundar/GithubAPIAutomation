package com.restassured.genericmethods;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class RestAssuredHTTPAPIRequests {

    public Response getRequestFromGithub(Cookie cookie, String endpoint) {
        System.out.println(endpoint);
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response postRequest(Cookie cookie, String endpoint, String body) {
        System.out.println(endpoint);
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .cookie(cookie)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

}
