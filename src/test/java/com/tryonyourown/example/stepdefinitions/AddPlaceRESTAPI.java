package com.tryonyourown.example.stepdefinitions;

import com.tryonyourown.example.utilities.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.FileNotFoundException;


public class AddPlaceRESTAPI implements RESTAPIInterface {
    RequestSpecification reqSpec;
    Response response;
    public AddPlaceRESTAPI setup() throws FileNotFoundException {
        Utils utils = new Utils();
        reqSpec = utils.buildRequestSpec();
        return this;
    }
    public AddPlaceRESTAPI setPayload(String payload) {
        System.out.println("Adding payload...");
        reqSpec = reqSpec.body(payload);
        return this;
    }
    public AddPlaceRESTAPI POST() {
        System.out.println("Sending POST Request...");
        response = reqSpec.when().post("/maps/api/place/add/json");
        return this;
    }
    public AddPlaceRESTAPI verifyBody(String key, String expectedValue) {
        System.out.println("Verifying the body...");
        JsonPath responseJson = new JsonPath(response.asString());
        Assert.assertEquals(responseJson.get(key).toString(), expectedValue);
        return this;
    }
    public AddPlaceRESTAPI verifyResponseStatusCode(String responseStatusCode) {
        System.out.println("Verifying response status code...");
        String responseString = response.then().assertThat().statusCode(Integer.parseInt(responseStatusCode)).extract().response().asString();
        System.out.println(responseString);
        Assert.assertEquals(responseStatusCode, "200");
        return this;
    }
}
