package com.bankaya.code.challenge.pokeapi_soap_service.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetPokemonRequest", namespace = "http://example.com/pokemon")
public class GetPokemonRequest {

    @XmlElement(required = true, namespace = "http://example.com/pokemon")
    private String name;

    // Default constructor
    public GetPokemonRequest() {
    }

    // Parameterized constructor
    public GetPokemonRequest(String name) {
        this.name = name;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
