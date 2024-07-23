package com.bankaya.code.challenge.pokeapi_soap_service.service;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bankaya.code.challenge.pokeapi_soap_service.entity.RequestLog;
import com.bankaya.code.challenge.pokeapi_soap_service.repository.RequestLogRepository;

import jakarta.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
public class LoggingAspectTest {

    @Mock
    private RequestLogRepository requestLogRepository;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private ProceedingJoinPoint proceedingJoinPoint;

    @Mock
    private Signature signature;

    @InjectMocks
    private LoggingAspect loggingAspect;

    @BeforeEach
    public void setUp() {
        when(httpServletRequest.getRemoteAddr()).thenReturn("127.0.0.1");
        when(proceedingJoinPoint.getSignature()).thenReturn(signature);
        when(signature.getName()).thenReturn("testMethod");
    }

    @Test
    public void testLogRequest() throws Throwable {
        Object[] args = new Object[] { new Object() };
        when(proceedingJoinPoint.getArgs()).thenReturn(args);
        when(proceedingJoinPoint.proceed()).thenReturn("response");

        Object result = loggingAspect.logRequest(proceedingJoinPoint);

        verify(requestLogRepository, times(1)).save(any(RequestLog.class));
        assert result.equals("response");
    }
}
