package com.bankaya.code.challenge.pokeapi_soap_service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.AbilitiesArrDTO;
import com.bankaya.code.challenge.pokeapi_soap_service.dto.HeldItemDTO;
import com.bankaya.code.challenge.pokeapi_soap_service.dto.PokemonDTO;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetAbilitiesResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetBaseExperienceResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetHeldItemsResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetIdResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetLocationAreaEncountersResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetNameResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class PokeApiService {

    private static final Logger logger = LoggerFactory.getLogger(PokeApiService.class);

    @Value("${pokeapi.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public PokemonDTO getPokemonResponse(String name) {
        log.info("Fetching Pokemon with name: {}", name);
        try {
            // Call to external API
            log.info("Pokemon fetched successfully");
            PokemonDTO pokemonDTO = restTemplate.getForObject(baseUrl + "/" + name, PokemonDTO.class);
            return pokemonDTO;
        } catch (Exception e) {
            log.error("Error fetching Pokemon: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public GetAbilitiesResponse getAbilitiesResponse(String name) {
        logger.info("Fetching abilities for Pokémon with name: {}", name);
        PokemonDTO pokemonByName = this.getPokemonResponse(name);
        List<AbilitiesArrDTO> abilities = pokemonByName.getAbilities();
        var response = new GetAbilitiesResponse(abilities);
        logger.info("Abilities fetched successfully for Pokémon {}: {}", name, abilities);
        return response;
    }

    public GetBaseExperienceResponse getBaseExperienceResponse(String name) {
        logger.info("Fetching base_experience for Pokémon with name: {}", name);
        PokemonDTO pokemonByName = this.getPokemonResponse(name);
        Integer baseExperience = pokemonByName.getBaseExperience();
        var response = new GetBaseExperienceResponse(baseExperience);
        logger.info("Base Experience fetched successfully for Pokémon {}: {}", name, baseExperience);
        return response;
    }

    public GetHeldItemsResponse getHeldItemsResponse(String name) {
        logger.info("Fetching held_items for Pokémon with name: {}", name);
        PokemonDTO pokemonByName = this.getPokemonResponse(name);
        List<HeldItemDTO> heldItems = pokemonByName.getHeldItems();
        var response = new GetHeldItemsResponse(heldItems);
        logger.info("Held Items fetched successfully for Pokémon {}: {}", name, heldItems);
        return response;
    }

    public GetIdResponse getIdResponse(String name) {
        logger.info("Fetching id for Pokémon with name: {}", name);
        PokemonDTO pokemonByName = this.getPokemonResponse(name);
        Long id = pokemonByName.getId();
        var response = new GetIdResponse(id);
        logger.info("id fetched successfully for Pokémon {}: {}", name, id);
        return response;
    }

    public GetNameResponse getNameResponse(String name) {
        logger.info("Fetching name for Pokémon with name: {}", name);
        PokemonDTO pokemonByName = this.getPokemonResponse(name);
        String pokemonName = pokemonByName.getName();
        var response = new GetNameResponse(pokemonName);
        logger.info("name fetched successfully for Pokémon {}: {}", name, pokemonName);
        return response;
    }

    public GetLocationAreaEncountersResponse getLocationAreaEncountersResponse(String name) {
        logger.info("Fetching Location Area Encounters for Pokémon with name: {}", name);
        PokemonDTO pokemonByName = this.getPokemonResponse(name);
        String locationAreaEncounters = pokemonByName.getLocationAreaEncounters();
        var response = new GetLocationAreaEncountersResponse(locationAreaEncounters);
        logger.info("locationAreaEncounters fetched successfully for Pokémon {}: {}", name, locationAreaEncounters);
        return response;
    }
}
