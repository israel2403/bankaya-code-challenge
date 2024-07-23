package com.bankaya.code.challenge.pokeapi_soap_service.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetPokemonRequest", namespace = "http://example.com/pokemon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPokemonRequest {

    @XmlElement(required = true, namespace = "http://example.com/pokemon")
    private String name;

}
