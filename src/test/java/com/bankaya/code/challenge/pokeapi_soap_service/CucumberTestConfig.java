package com.bankaya.code.challenge.pokeapi_soap_service;

import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = PokeapiSoapServiceApplication.class)
public class CucumberTestConfig {
}
