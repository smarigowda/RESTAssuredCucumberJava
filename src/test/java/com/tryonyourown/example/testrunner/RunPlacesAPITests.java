package com.tryonyourown.example.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/tryonyourown/example/feature", glue ="com.tryonyourown.example.stepdefinitions")
public class RunPlacesAPITests {
}
