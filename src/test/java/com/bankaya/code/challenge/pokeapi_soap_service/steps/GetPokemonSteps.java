package com.bankaya.code.challenge.pokeapi_soap_service.steps;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.ws.test.server.RequestCreators.*;
import static org.springframework.ws.test.server.ResponseMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import com.bankaya.code.challenge.pokeapi_soap_service.PokeapiSoapServiceApplication;
import com.bankaya.code.challenge.pokeapi_soap_service.dto.PokemonDTO;
import com.bankaya.code.challenge.pokeapi_soap_service.service.PokeApiService;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest(classes = PokeapiSoapServiceApplication.class)
public class GetPokemonSteps {

    @Autowired
    private ApplicationContext applicationContext;

    private MockWebServiceClient mockClient;

    @MockBean
    private PokeApiService pokeApiService;

    private String requestPayload;
    private String responsePayload;

    @Before
    public void setup() {
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }

    @Given("a request to get Pokemon with name {string}")
    public void a_request_to_get_pokemon_with_name(String name) {
        requestPayload = "<GetPokemonRequest xmlns=\"http://example.com/pokemon\"><name>" + name
                + "</name></GetPokemonRequest>";

        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(25L);
        pokemonDTO.setName(name);
        when(pokeApiService.getPokemonResponse(anyString())).thenReturn(pokemonDTO);
    }

    @When("the request is made")
    public void the_request_is_made() throws Exception {
        responsePayload = "<GetPokemonResponse xmlns=\"http://example.com/pokemon\"><pokemon><id>25</id><name>"
                + requestPayload.split(">")[2].split("<")[0] + "</name></pokemon></GetPokemonResponse>";
        mockClient.sendRequest(withPayload(new StringSource(requestPayload)))
                .andExpect(payload(new StringSource(responsePayload)));
    }

    @Then("the response contains the Pokemon with name {string}")
    public void the_response_contains_the_pokemon_with_name(String name) {
        // This step is to assert the response is correct
    }
}