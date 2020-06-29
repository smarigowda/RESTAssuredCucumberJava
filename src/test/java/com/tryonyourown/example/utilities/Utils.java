package com.tryonyourown.example.utilities;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Utils {
    public RequestSpecification buildRequestSpec() throws FileNotFoundException {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        var logfile = new PrintStream("request.log");
        RequestSpecification reqSpec = RestAssured.given()
                                                    .queryParam("key", "qaclick123")
                                                    .contentType(ContentType.JSON)
                                                    .filter(RequestLoggingFilter.logRequestTo(logfile))
                                                    .filter(ResponseLoggingFilter.logResponseTo(logfile));
        return reqSpec;
    }
}
