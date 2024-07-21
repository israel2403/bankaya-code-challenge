package com.bankaya.code.challenge.pokeapi_soap_service.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
@XmlRootElement(name = "HeldItemDTO")
public class HeldItemDTO {

    @XmlElement(required = true)
    private ItemDTO item;

    @JsonProperty(value = "version_details")
    @XmlElement(name = "version_details", required = true)
    private List<VersionDetailsDTO> versionDetails;
}
