package com.bankaya.code.challenge.pokeapi_soap_service.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.GetPokemonResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.dto.PokemonDTO;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetPokemonRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.service.PokeApiService;

import lombok.RequiredArgsConstructor;

@Endpoint
@RequiredArgsConstructor
public class PokemonController {
    private static final String NAMESPACE_URI = "http://example.com/pokemon";
    private final PokeApiService pokeApiService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {
        String name = request.getName();
        PokemonDTO pokemon = pokeApiService.getPokemonByName(name);
        GetPokemonResponse response = new GetPokemonResponse();
        response.setPokemon(pokemon);
        return response;
    }
}