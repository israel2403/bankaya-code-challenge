package com.bankaya.code.challenge.pokeapi_soap_service.dto;

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
@XmlRootElement(name = "VersionDetailsDTO")
public class VersionDetailsDTO {

    @XmlElement(required = true)
    private Integer rarity;

    @XmlElement(required = true)
    private VersionDTO version;
}