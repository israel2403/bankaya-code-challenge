package com.bankaya.code.challenge.pokeapi_soap_service.response;

import java.util.List;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.HeldItemDTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "GetHeldItemsResponse", namespace = "http://example.com/pokemon")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetHeldItemsResponse {

    @XmlElement(name = "held_items", required = true)
    private List<HeldItemDTO> heldItems;
}
