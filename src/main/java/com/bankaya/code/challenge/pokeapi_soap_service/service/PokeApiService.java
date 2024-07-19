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

    public PokemonDTO getPokemonByName(String name) {
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

    public GetAbilitiesResponse getAbilitiesFromPokemon(String name) {
        logger.info("Fetching abilities for Pokémon with name: {}", name);
        PokemonDTO pokemonByName = this.getPokemonByName(name);
        List<AbilitiesArrDTO> abilities = pokemonByName.getAbilities();
        GetAbilitiesResponse response = new GetAbilitiesResponse();
        response.setAbilities(abilities);
        logger.info("Abilities fetched successfully for Pokémon {}: {}", name, abilities);
        return response;
    }

    public GetBaseExperienceResponse getBaseExperienceFromPokemon(String name) {
        logger.info("Fetching base_experience for Pokémon with name: {}", name);
        PokemonDTO pokemonByName = this.getPokemonByName(name);
        Integer baseExperience = pokemonByName.getBaseExperience();
        GetBaseExperienceResponse response = new GetBaseExperienceResponse();
        response.setBaseExperience(baseExperience);
        logger.info("Base Experience fetched successfully for Pokémon {}: {}", name, baseExperience);
        return response;
    }

    public GetHeldItemsResponse getHeldItemsFromPokemon(String name) {
        logger.info("Fetching held_items for Pokémon with name: {}", name);
        PokemonDTO pokemonByName = this.getPokemonByName(name);
        List<HeldItemDTO> heldItems = pokemonByName.getHeldItems();
        GetHeldItemsResponse response = new GetHeldItemsResponse();
        response.setHeldItems(heldItems);
        logger.info("Held Items fetched successfully for Pokémon {}: {}", name, heldItems);
        return response;
    }
}
