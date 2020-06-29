package com.tryonyourown.example.stepdefinitions;

import java.io.FileNotFoundException;

public interface RESTAPIInterface {
    RESTAPIInterface setup() throws FileNotFoundException;
    RESTAPIInterface setPayload(String payload);
    RESTAPIInterface POST();
    RESTAPIInterface verifyBody(String key, String value);
    RESTAPIInterface verifyResponseStatusCode(String statusCode);

}
