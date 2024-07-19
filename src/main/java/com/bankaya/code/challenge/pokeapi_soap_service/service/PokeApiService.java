package com.bankaya.code.challenge.pokeapi_soap_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.PokemonDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class PokeApiService {

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
}
