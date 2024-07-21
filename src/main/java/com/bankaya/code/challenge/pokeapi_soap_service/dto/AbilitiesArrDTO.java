package com.bankaya.code.challenge.pokeapi_soap_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@XmlRootElement(name = "AbilitiesArrDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbilitiesArrDTO {

    @XmlElement(required = true)
    private AbilityDTO ability;

    @JsonProperty("is_hidden")
    @XmlElement(name = "is_hidden", required = true)
    private boolean hidden;

    @XmlElement(required = true)
    private Integer slot;
}
