Feature: Validate Places API

  Scenario: Add Place API should add a place successfully
    Given Add Place Payload
    When User calls Add Place API with POST http request
    Then Add Place API should return success response with status code 200
    And Status in response body should be OK