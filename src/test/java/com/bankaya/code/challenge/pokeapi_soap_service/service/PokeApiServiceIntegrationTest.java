package com.bankaya.code.challenge.pokeapi_soap_service.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.bankaya.code.challenge.pokeapi_soap_service.configuration.RestTemplateConfig;
import com.bankaya.code.challenge.pokeapi_soap_service.dto.PokemonDTO;

@SpringBootTest
@ContextConfiguration(classes = {PokeApiService.class, RestTemplateConfig.class})
@ComponentScan(basePackages = "com.bankaya.code.challenge.pokeapi_soap_service")
@TestPropertySource(properties = "pokeapi.base-url=https://pokeapi.co/api/v2/pokemon")
public class PokeApiServiceIntegrationTest {

    @Autowired
    private PokeApiService pokeApiService;


    @Value("${pokeapi.base-url}")
    private String baseUrl;

    @Test
    public void testGetPokemonByName() {
        String pokemonName = "pikachu";

        PokemonDTO pokemonDTO = pokeApiService.getPokemonByName(pokemonName);

        assertNotNull(pokemonDTO, "PokemonDTO should not be null");
        assertEquals(pokemonName, pokemonDTO.getName().toLowerCase(), "Pokemon name should match");

        // Additional validations
        assertNotNull(pokemonDTO.getId(), "Pokemon ID should not be null");
        assertNotNull(pokemonDTO.getBaseExperience(), "Base experience should not be null");
        assertNotNull(pokemonDTO.getAbilities(), "Abilities list should not be null");
        assertNotNull(pokemonDTO.getHeldItems(), "Held items list should not be null");
        assertNotNull(pokemonDTO.getLocationAreaEncounters(), "Location area encounters should not be null");

        assertFalse(pokemonDTO.getAbilities().isEmpty(), "Abilities list should not be empty");
        assertFalse(pokemonDTO.getHeldItems().isEmpty(), "Held items list should not be empty");

        // Further validations for a specific ability or held item can be added if needed
        // For example, checking the first ability and held item
        assertNotNull(pokemonDTO.getAbilities().get(0), "First ability should not be null");
        assertNotNull(pokemonDTO.getHeldItems().get(0), "First held item should not be null");
    }
}
