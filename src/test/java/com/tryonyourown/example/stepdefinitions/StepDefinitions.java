package com.tryonyourown.example.stepdefinitions;

import com.tryonyourown.example.testdata.AddPlace;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    AddPlaceRESTAPI addPlaceApi = new AddPlaceRESTAPI();

    @Given("Add Place Payload")
    public void add_place_payload() {
        // TO DO
        // setup should not be here
        // it should be moved to before all step
        addPlaceApi.setup().setPayload(AddPlace.getPayload());
    }

    @When("User calls {string} with POST http request")
    public void user_calls_with_post_http_request(String string) {
        addPlaceApi.POST();
    }

    @Then("Add Place API should return success response with status code {string}")
    public void add_place_api_should_return_success_response_with_status_code(String responseStatusCode) {
        addPlaceApi.verifyResponseStatusCode(responseStatusCode);
    }
    @Then("{string} in response body should be {string}")
    public void in_response_body_should_be(String name, String value) {
        addPlaceApi.verifyBody(name, value);
    }
}
