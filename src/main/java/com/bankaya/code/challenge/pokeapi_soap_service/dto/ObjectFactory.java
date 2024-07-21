package com.bankaya.code.challenge.pokeapi_soap_service.dto;

import com.bankaya.code.challenge.pokeapi_soap_service.response.GetAbilitiesResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetBaseExperienceResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetHeldItemsResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetIdResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetLocationAreaEncountersResponse;
import com.bankaya.code.challenge.pokeapi_soap_service.response.GetNameResponse;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {}

    public PokemonDTO createPokemonDTO() {
        return new PokemonDTO();
    }

    public AbilitiesArrDTO createAbilitiesArrDTO() {
        return new AbilitiesArrDTO();
    }

    public HeldItemDTO createHeldItemDTO() {
        return new HeldItemDTO();
    }

    public AbilityDTO createAbilityDTO() {
        return new AbilityDTO();
    }

    public GetPokemonResponse createGetPokemonResponse() {
        return new GetPokemonResponse();
    }

    public GetAbilitiesResponse createGetAbilitiesResponse() {
        return new GetAbilitiesResponse();
    }

    public GetBaseExperienceResponse createGetBaseExperienceResponse() {
        return new GetBaseExperienceResponse();
    }

    public GetHeldItemsResponse createGetHeldItemsResponse() {
        return new GetHeldItemsResponse();
    }

    public GetIdResponse createGetIdResponse() {
        return new GetIdResponse();
    }

    public GetLocationAreaEncountersResponse createGetLocationAreaEncountersResponse() {
        return new GetLocationAreaEncountersResponse();
    }

    public GetNameResponse createGetNameResponse() {
        return new GetNameResponse();
    }
}
