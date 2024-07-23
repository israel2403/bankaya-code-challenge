package com.bankaya.code.challenge.pokeapi_soap_service.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponseDTO {
    
    private String errorMessage;

    private HttpStatus errorCode;
}
