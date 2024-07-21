package com.bankaya.code.challenge.pokeapi_soap_service.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * GetBaseExperienceRequest
 */
@XmlRootElement(name = "GetBaseExperienceRequest", namespace = "http://example.com/pokemon")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBaseExperienceRequest {

    @XmlElement(name = "name", namespace = "http://example.com/pokemon", required = true)
    private String name; 
}