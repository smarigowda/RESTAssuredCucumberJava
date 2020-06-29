package com.tryonyourown.example.stepdefinitions;

public interface RESTAPIInterface {
    RESTAPIInterface setup();
    RESTAPIInterface setPayload(String payload);
    RESTAPIInterface POST();
    RESTAPIInterface verifyBody(String key, String value);
    RESTAPIInterface verifyResponseStatusCode(String statusCode);

}
