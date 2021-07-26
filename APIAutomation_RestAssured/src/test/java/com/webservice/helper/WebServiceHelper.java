package com.webservice.helper;

import com.restassured.genericmethods.RestAssuredHTTPAPIRequests;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import jdk.nashorn.internal.parser.JSONParser;
import org.testng.Assert;

public class WebServiceHelper {

    private final RestAssuredHTTPAPIRequests restAssuredHTTPAPIRequests = new RestAssuredHTTPAPIRequests();
    private final String baseURL = "https://api.github.com/";
    Cookie cookie;

    /** @author Somu
     * @description Method will fetch the list of repos from GitHub
     */
    public void getRepos(String username , String token) {
        String url = baseURL + "users/suryasomasundar/repos";
        Response response = restAssuredHTTPAPIRequests.getRequestFromGithub(cookie , url);
        System.out.println("Response for Login Request " + response.statusCode());
        System.out.println("Response Body"+ response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);
        RestAssured.defaultParser = Parser.JSON;
        String jsonResponse = response.jsonPath().getString("name");
        System.out.println("Name"+jsonResponse );
        Assert.assertEquals(jsonResponse.contains("awesome-project-management") ,true);
    }

}
