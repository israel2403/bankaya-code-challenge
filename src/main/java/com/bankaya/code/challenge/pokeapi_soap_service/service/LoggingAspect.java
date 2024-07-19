package com.bankaya.code.challenge.pokeapi_soap_service.service;

import java.io.StringWriter;
import java.time.LocalDateTime;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.xml.transform.StringResult;

import com.bankaya.code.challenge.pokeapi_soap_service.entity.RequestLog;
import com.bankaya.code.challenge.pokeapi_soap_service.interceptor.SoapResponseInterceptor;
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
        log.setResponse(responseToXml());

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

    private String responseToXml() {
        try {
            SoapMessage response = SoapResponseInterceptor.getResponseMessage();
            if (response == null) {
                logger.warn("No response message found.");
                return "No response message found.";
            }

            StringResult result = new StringResult();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(response.getEnvelope().getSource(), result);
            SoapResponseInterceptor.clear();
            return result.toString();
        } catch (Exception e) {
            logger.error("Error converting response to XML: " + e.getMessage(), e);
            return "Error converting response to XML: " + e.getMessage();
        }
    }
}
