package com.bankaya.code.challenge.pokeapi_soap_service.response;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.PokemonDTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetPokemonResponse", namespace = "http://example.com/pokemon")
public class GetPokemonResponse {

    @XmlElement(required = true, namespace = "http://example.com/pokemon")
    private PokemonDTO pokemon;

    // Default constructor
    public GetPokemonResponse() {
    }

    // Parameterized constructor
    public GetPokemonResponse(PokemonDTO pokemon) {
        this.pokemon = pokemon;
    }

    // Getter and Setter
    public PokemonDTO getPokemon() {
        return pokemon;
    }

    public void setPokemon(PokemonDTO pokemon) {
        this.pokemon = pokemon;
    }
}
