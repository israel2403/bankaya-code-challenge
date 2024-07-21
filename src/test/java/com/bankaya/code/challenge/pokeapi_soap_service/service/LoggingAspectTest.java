package com.bankaya.code.challenge.pokeapi_soap_service.service;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bankaya.code.challenge.pokeapi_soap_service.entity.RequestLog;
import com.bankaya.code.challenge.pokeapi_soap_service.interceptor.SoapResponseInterceptor;
import com.bankaya.code.challenge.pokeapi_soap_service.repository.RequestLogRepository;

import jakarta.servlet.http.HttpServletRequest;

public class LoggingAspectTest {

    @Mock
    private RequestLogRepository requestLogRepository;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private ProceedingJoinPoint joinPoint;

    @Mock
    private MethodSignature methodSignature;

    @InjectMocks
    private LoggingAspect loggingAspect;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void logRequest_Success() throws Throwable {
        // Arrange
        when(joinPoint.getSignature()).thenReturn(methodSignature);
        when(methodSignature.getName()).thenReturn("getPokemon");
        when(httpServletRequest.getRemoteAddr()).thenReturn("127.0.0.1");

        Object[] args = new Object[]{new GetPokemonRequest("pikachu")};
        when(joinPoint.getArgs()).thenReturn(args);

        SoapResponseInterceptor.clear(); // Ensure there is no response

        when(joinPoint.proceed()).thenReturn(new GetPokemonResponse("pikachu"));

        // Act
        loggingAspect.logRequest(joinPoint);

        // Assert
        verify(joinPoint, times(1)).proceed();
        verify(requestLogRepository, times(1)).save(any(RequestLog.class));
    }

    private static class GetPokemonRequest {
        private String name;

        public GetPokemonRequest(String name) {
            this.name = name;
        }

        // Getters and setters (if needed)
    }

    private static class GetPokemonResponse {
        private String name;

        public GetPokemonResponse(String name) {
            this.name = name;
        }

        // Getters and setters (if needed)
    }
}
