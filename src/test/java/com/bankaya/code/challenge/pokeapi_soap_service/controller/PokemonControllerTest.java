package com.bankaya.code.challenge.pokeapi_soap_service.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ws.context.MessageContext;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.PokemonDTO;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetBaseExperienceRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetHeldItemsRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetIdRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetLocationAreaEncountersRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetNameRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetPokemonRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetBaseExperienceResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetHeldItemsResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetIdResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetLocationAreaEncountersResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetNameResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetPokemonResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.service.PokeApiService;

@ExtendWith(MockitoExtension.class)
public class PokemonControllerTest {

    @Mock
    private PokeApiService pokeApiService;

    @Mock
    private MessageContext messageContext;

    @InjectMocks
    private PokemonController pokemonController;

    @BeforeEach
    void setUp() {
        pokemonController = new PokemonController(pokeApiService);
    }

    @Test
    void testGetPokemon() {
        // Arrange
        GetPokemonRequest request = new GetPokemonRequest("bulbasaur");
        PokemonDTO pokemonDTO = new PokemonDTO(1L, null, 64, null, "bulbasaur", "location_area");
        given(pokeApiService.getPokemonResponse("bulbasaur")).willReturn(pokemonDTO);

        // Act
        GetPokemonResponse response = pokemonController.getPokemon(request, messageContext);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getPokemon()).isEqualTo(pokemonDTO);
    }

    
    @Test
    void testGetBaseExperience() {
        // Arrange
        GetBaseExperienceRequest request = new GetBaseExperienceRequest("bulbasaur");
        GetBaseExperienceResponse baseExperienceResponse = new GetBaseExperienceResponse(64);
        given(pokeApiService.getBaseExperienceResponse("bulbasaur")).willReturn(baseExperienceResponse);

        // Act
        GetBaseExperienceResponse response = pokemonController.getBasedExperienceByName(request, messageContext);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getBaseExperience()).isEqualTo(64);
    }

    @Test
    void testGetHeldItems() {
        // Arrange
        GetHeldItemsRequest request = new GetHeldItemsRequest("bulbasaur");
        GetHeldItemsResponse heldItemsResponse = new GetHeldItemsResponse();
        given(pokeApiService.getHeldItemsResponse("bulbasaur")).willReturn(heldItemsResponse);

        // Act
        GetHeldItemsResponse response = pokemonController.getHeldItemsByName(request, messageContext);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getHeldItems()).isEqualTo(heldItemsResponse.getHeldItems());
    }

    @Test
    void testGetId() {
        // Arrange
        GetIdRequest request = new GetIdRequest("bulbasaur");
        GetIdResponse idResponse = new GetIdResponse(1L);
        given(pokeApiService.getIdResponse("bulbasaur")).willReturn(idResponse);

        // Act
        GetIdResponse response = pokemonController.getIdByName(request, messageContext);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
    }

    @Test
    void testGetName() {
        // Arrange
        GetNameRequest request = new GetNameRequest("bulbasaur");
        GetNameResponse nameResponse = new GetNameResponse("bulbasaur");
        given(pokeApiService.getNameResponse("bulbasaur")).willReturn(nameResponse);

        // Act
        GetNameResponse response = pokemonController.getNameByName(request, messageContext);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getName()).isEqualTo("bulbasaur");
    }

    @Test
    void testGetLocationAreaEncounters() {
        // Arrange
        GetLocationAreaEncountersRequest request = new GetLocationAreaEncountersRequest("bulbasaur");
        GetLocationAreaEncountersResponse locationAreaEncountersResponse = new GetLocationAreaEncountersResponse("location_area");
        given(pokeApiService.getLocationAreaEncountersResponse("bulbasaur")).willReturn(locationAreaEncountersResponse);

        // Act
        GetLocationAreaEncountersResponse response = pokemonController.getLocationAreaEncountersByName(request, messageContext);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response.getLocationAreaEncounters()).isEqualTo("location_area");
    }
}
