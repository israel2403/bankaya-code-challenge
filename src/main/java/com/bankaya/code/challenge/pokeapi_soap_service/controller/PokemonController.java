package com.bankaya.code.challenge.pokeapi_soap_service.controller;



import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bankaya.code.challenge.pokeapi_soap_service.request.GetAbilitiesRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetBaseExperienceRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetHeldItemsRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetIdRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetLocationAreaEncountersRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetNameRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.request.GetPokemonRequest;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetAbilitiesResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetBaseExperienceResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetHeldItemsResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetIdResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetLocationAreaEncountersResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetNameResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetPokemonResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.service.PokeApiService;

import lombok.RequiredArgsConstructor;

@Endpoint
@RequiredArgsConstructor
public class PokemonController {

    private static final String NAMESPACE_URI = "http://example.com/pokemon";
    private final PokeApiService pokeApiService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request, MessageContext messageContext) {
        GetPokemonResponse response = new GetPokemonResponse();
        response.setPokemon(pokeApiService.getPokemonResponse(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAbilitiesRequest")
    @ResponsePayload
    public GetAbilitiesResponse getAbilities(@RequestPayload GetAbilitiesRequest request, MessageContext messageContext) {
        var abilities = pokeApiService.getAbilitiesResponse(request.getName()).getAbilities();
        GetAbilitiesResponse response = new GetAbilitiesResponse();
        response.setAbilities(abilities);
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBaseExperienceRequest")
    @ResponsePayload
    public GetBaseExperienceResponse getBasedExperienceByName(@RequestPayload GetBaseExperienceRequest request, MessageContext messageContext) {
        var response= pokeApiService.getBaseExperienceResponse(request.getName());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetHeldItemsRequest")
    @ResponsePayload
    public GetHeldItemsResponse getHeldItemsByName(@RequestPayload GetHeldItemsRequest request, MessageContext messageContext) {
        var response= pokeApiService.getHeldItemsResponse(request.getName());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetIdRequest")
    @ResponsePayload
    public GetIdResponse getIdByName(@RequestPayload GetIdRequest request, MessageContext messageContext) {
        var response= pokeApiService.getIdResponse(request.getName());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetNameRequest")
    @ResponsePayload
    public GetNameResponse getNameByName(@RequestPayload GetNameRequest request, MessageContext messageContext) {
        var response= pokeApiService.getNameResponse(request.getName());
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetLocationAreaEncountersRequest")
    @ResponsePayload
    public GetLocationAreaEncountersResponse getLocationAreaEncountersByName(@RequestPayload GetLocationAreaEncountersRequest request, MessageContext messageContext) {
        var response= pokeApiService.getLocationAreaEncountersResponse(request.getName());
        return response;
    }
}
