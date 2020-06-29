package com.tryonyourown.example.utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
    public RequestSpecification buildRequestSpec() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        RequestSpecification reqSpec = RestAssured.given().queryParam("key", "qaclick123").contentType(ContentType.JSON);
        return reqSpec;
    }
}
