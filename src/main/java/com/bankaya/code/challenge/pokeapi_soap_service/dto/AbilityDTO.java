package com.bankaya.code.challenge.pokeapi_soap_service.dto;

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
@XmlRootElement(name = "AbilityDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbilityDTO {

    @XmlElement(required = true)
    private String name;

    @XmlElement(required = true)
    private String url;
}
