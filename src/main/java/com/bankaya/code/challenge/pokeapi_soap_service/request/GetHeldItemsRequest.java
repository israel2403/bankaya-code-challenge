package com.bankaya.code.challenge.pokeapi_soap_service.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "GetHeldItemsRequest", namespace = "http://example.com/pokemon")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class GetHeldItemsRequest {
    @XmlElement(name = "name", namespace = "http://example.com/pokemon", required = true)
    private String name;
}
