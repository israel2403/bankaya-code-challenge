package com.bankaya.code.challenge.pokeapi_soap_service.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.PokemonDTO;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetAbilitiesResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetBaseExperienceResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetHeldItemsResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetIdResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetLocationAreaEncountersResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetNameResponse;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class PokeApiServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PokeApiService pokeApiService;

    private PokemonDTO pokemonDTO;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        // Use reflection to set the baseUrl field
        Field baseUrlField = PokeApiService.class.getDeclaredField("baseUrl");
        baseUrlField.setAccessible(true);
        baseUrlField.set(pokeApiService, "https://pokeapi.co/api/v2/pokemon");

        var objectMapper = new ObjectMapper();
        pokemonDTO = objectMapper.readValue(new File("src/test/resources/json/service/pokemon-dto.json"),
                PokemonDTO.class);
    }

    @Test
    void getPokemonResponse_Success() throws StreamReadException, DatabindException, IOException {
        String pokemonName = "pikachu";
        PokemonDTO mockPokemonDTO = new PokemonDTO();
        mockPokemonDTO.setName(pokemonName);

        ResponseEntity<PokemonDTO> responseEntity = new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
        when(restTemplate.getForEntity(anyString(), eq(PokemonDTO.class))).thenReturn(responseEntity);

        PokemonDTO result = pokeApiService.getPokemonResponse(pokemonName);

        assertEquals(pokemonDTO.getName(), result.getName());
    }

    @Test
    void getPokemonResponse_Failure() {
        String pokemonName = "unknown";
        when(restTemplate.getForEntity(anyString(), eq(PokemonDTO.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        assertThrows(RuntimeException.class, () -> pokeApiService.getPokemonResponse(pokemonName));
    }

    @Test
    void getAbilitiesResponse_Success() {
        String pokemonName = "pikachu";
        ResponseEntity<PokemonDTO> responseEntity = new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
        when(restTemplate.getForEntity(anyString(), eq(PokemonDTO.class))).thenReturn(responseEntity);

        GetAbilitiesResponse response = pokeApiService.getAbilitiesResponse(pokemonName);

        assertNotNull(response);
        assertEquals(pokemonDTO.getAbilities().size(), response.getAbilities().size());
    }

    @Test
    void getBaseExperienceResponse_Success() {
        String pokemonName = "pikachu";
        ResponseEntity<PokemonDTO> responseEntity = new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
        when(restTemplate.getForEntity(anyString(), eq(PokemonDTO.class))).thenReturn(responseEntity);

        GetBaseExperienceResponse response = pokeApiService.getBaseExperienceResponse(pokemonName);

        assertNotNull(response);
        assertEquals(pokemonDTO.getBaseExperience(), response.getBaseExperience());
    }

    @Test
    void getHeldItemsResponse_Success() {
        String pokemonName = "pikachu";
        ResponseEntity<PokemonDTO> responseEntity = new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
        when(restTemplate.getForEntity(anyString(), eq(PokemonDTO.class))).thenReturn(responseEntity);

        GetHeldItemsResponse response = pokeApiService.getHeldItemsResponse(pokemonName);

        assertNotNull(response);
        assertEquals(pokemonDTO.getHeldItems().size(), response.getHeldItems().size());
    }

    @Test
    void getIdResponse_Success() {
        String pokemonName = "pikachu";
        ResponseEntity<PokemonDTO> responseEntity = new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
        when(restTemplate.getForEntity(anyString(), eq(PokemonDTO.class))).thenReturn(responseEntity);

        GetIdResponse response = pokeApiService.getIdResponse(pokemonName);

        assertNotNull(response);
        assertEquals(pokemonDTO.getId(), response.getId());
    }

    @Test
    void getNameResponse_Success() {
        String pokemonName = "pikachu";
        ResponseEntity<PokemonDTO> responseEntity = new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
        when(restTemplate.getForEntity(anyString(), eq(PokemonDTO.class))).thenReturn(responseEntity);

        GetNameResponse response = pokeApiService.getNameResponse(pokemonName);

        assertNotNull(response);
        assertEquals(pokemonDTO.getName(), response.getName());
    }

    @Test
    void getLocationAreaEncountersResponse_Success() {
        String pokemonName = "pikachu";
        ResponseEntity<PokemonDTO> responseEntity = new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
        when(restTemplate.getForEntity(anyString(), eq(PokemonDTO.class))).thenReturn(responseEntity);

        GetLocationAreaEncountersResponse response = pokeApiService.getLocationAreaEncountersResponse(pokemonName);

        assertNotNull(response);
        assertEquals(pokemonDTO.getLocationAreaEncounters(), response.getLocationAreaEncounters());
    }

}
