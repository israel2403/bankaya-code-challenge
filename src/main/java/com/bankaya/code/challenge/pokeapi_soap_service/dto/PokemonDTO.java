package com.bankaya.code.challenge.pokeapi_soap_service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* 
● abilities
● base_experience *
● held_items *
● id *
● name *
● location_area_encounters *
*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@XmlRootElement(name = "PokemonDTO")
@ToString
@Setter
public class PokemonDTO {
    @XmlElement(required = true)
    private Long id;

    @XmlElement
    private List<AbilitiesArrDTO> abilities;

    @XmlElement(name = "base_experience")
    @JsonProperty("base_experience")
    private Integer baseExperience;

    @XmlElement(name = "held_items")
    @JsonProperty("held_items")
    private List<HeldItemDTO> heldItems;

    @XmlElement(required = true)
    private String name;

    @XmlElement(name = "location_area_encounters")
    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;
}
