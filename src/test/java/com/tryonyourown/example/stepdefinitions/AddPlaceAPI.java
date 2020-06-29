package com.tryonyourown.example.stepdefinitions;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;


public class AddPlaceAPI {
    RequestSpecification reqSpec;
    Response response;
    public AddPlaceAPI setup() {
        System.out.println("Setting up defaults...");
        RestAssured.baseURI="https://rahulshettyacademy.com";
        return this;
    }
    public AddPlaceAPI setPayload(String payload) {
        System.out.println("Adding payload...");
        reqSpec = RestAssured.given().body(payload).queryParam("key", "qaclick123");
        return this;
    }
    public AddPlaceAPI POST() {
        System.out.println("Sending POST Request...");
        response = reqSpec.when().post("/maps/api/place/add/json");
        return this;
    }
    public AddPlaceAPI verifyBody(String key, String expectedValue) {
        System.out.println("Verifying the body...");
        JsonPath responseJson = new JsonPath(response.asString());
        Assert.assertEquals(responseJson.get(key).toString(), expectedValue);
        return this;
    }
    public AddPlaceAPI verifyResponseStatusCode(String responseStatusCode) {
        System.out.println("Verifying response status code...");
        String responseString = response.then().assertThat().statusCode(Integer.parseInt(responseStatusCode)).extract().response().asString();
        System.out.println(responseString);
        Assert.assertEquals(responseStatusCode, "200");
        return this;
    }
}
