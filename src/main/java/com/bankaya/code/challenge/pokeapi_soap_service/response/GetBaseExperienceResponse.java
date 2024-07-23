package com.bankaya.code.challenge.pokeapi_soap_service.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "GetBaseExperienceResponse", namespace = "http://example.com/pokemon")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBaseExperienceResponse {
    
    @XmlElement(name = "base_experience", required = true)
    private Integer baseExperience;
}
