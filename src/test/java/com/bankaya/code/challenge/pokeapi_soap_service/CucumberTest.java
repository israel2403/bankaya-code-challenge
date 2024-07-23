package com.bankaya.code.challenge.pokeapi_soap_service;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty", "html:target/cucumber.html"})
public class CucumberTest {
}
