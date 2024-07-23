package com.bankaya.code.challenge.pokeapi_soap_service.error;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import com.bankaya.code.challenge.pokeapi_soap_service.dto.ErrorResponseDTO;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void testHandleGlobalException() {
        Exception exception = new Exception("Test exception");
        WebRequest request = mock(WebRequest.class);

        ResponseEntity<ErrorResponseDTO> response = globalExceptionHandler.handleGlobalException(exception, request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Test exception", response.getBody().getErrorMessage());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getBody().getErrorCode());
    }

    @Test
    void testHandleResourceNotFoundException() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Resource not found");
        WebRequest request = mock(WebRequest.class);

        ResponseEntity<ErrorResponseDTO> response = globalExceptionHandler.handleCustomerNotFoundException(exception, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Resource not found", response.getBody().getErrorMessage());
        assertEquals(HttpStatus.NOT_FOUND, response.getBody().getErrorCode());
    }
}
