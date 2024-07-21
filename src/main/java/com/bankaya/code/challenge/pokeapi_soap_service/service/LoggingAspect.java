package com.bankaya.code.challenge.pokeapi_soap_service.service;

import java.io.StringWriter;
import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankaya.code.challenge.pokeapi_soap_service.entity.RequestLog;
import com.bankaya.code.challenge.pokeapi_soap_service.repository.RequestLogRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private RequestLogRepository requestLogRepository;

    @Autowired
    private HttpServletRequest httpServletRequest;

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(org.springframework.ws.server.endpoint.annotation.PayloadRoot)")
    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;

        RequestLog log = new RequestLog();
        log.setIp(httpServletRequest.getRemoteAddr());
        log.setRequestDate(LocalDateTime.now());
        log.setMethod(joinPoint.getSignature().getName());
        log.setDuration(duration);
        log.setRequest(objectToXml(joinPoint.getArgs()));
        log.setResponse("");

        requestLogRepository.save(log);
        logger.info("Request and response logged successfully");
        return proceed;
    }

    private String objectToXml(Object[] objects) {
        try {
            JAXBContext context = JAXBContext.newInstance(objects[0].getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            marshaller.marshal(objects[0], sw);
            return sw.toString();
        } catch (JAXBException e) {
            logger.error("Error converting object to XML: " + e.getMessage(), e);
            return "Error converting object to XML: " + e.getMessage();
        }
    }
}
