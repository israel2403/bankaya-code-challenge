package com.bankaya.code.challenge.pokeapi_soap_service.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.ErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGlobalException(Exception ex, WebRequest request) {
        final ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR).errorMessage(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerNotFoundException(ResourceNotFoundException exception,
            WebRequest webRequest) {
        logger.error("Handling CustomerNotFoundException: {}", exception.getMessage());
        final ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .errorCode(HttpStatus.NOT_FOUND).errorMessage(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }
}
