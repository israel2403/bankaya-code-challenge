package com.bankaya.code.challenge.pokeapi_soap_service.response;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.PokemonDTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetPokemonResponse", namespace = "http://example.com/pokemon")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetPokemonResponse {

    @XmlElement(required = true, namespace = "http://example.com/pokemon")
    private PokemonDTO pokemon;
}
