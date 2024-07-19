package com.bankaya.code.challenge.pokeapi_soap_service.controller;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapMessage;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.GetPokemonResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetPokemonRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.service.PokeApiService;

import lombok.RequiredArgsConstructor;

@Endpoint
@RequiredArgsConstructor
public class PokemonController {

    private static final String NAMESPACE_URI = "http://example.com/pokemon";
    private final PokeApiService pokeApiService;
    private static final ThreadLocal<SoapMessage> responseMessageHolder = new ThreadLocal<>();

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request, MessageContext messageContext) {
        GetPokemonResponse response = new GetPokemonResponse();
        response.setPokemon(pokeApiService.getPokemonByName(request.getName()));
        responseMessageHolder.set((SoapMessage) messageContext.getResponse());
        return response;
    }

    public static SoapMessage getResponseMessage() {
        return responseMessageHolder.get();
    }

    public static void clear() {
        responseMessageHolder.remove();
    }
}
