package com.bankaya.code.challenge.pokeapi_soap_service.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapMessage;

@Component
public class SoapResponseInterceptor implements EndpointInterceptor {

    private static final ThreadLocal<SoapMessage> responseMessageHolder = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(SoapResponseInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        // Do nothing on request
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        SoapMessage response = (SoapMessage) messageContext.getResponse();
        responseMessageHolder.set(response);
        logger.info("SOAP Response captured: " + response.toString());
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        // Do nothing on fault
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        // Clear the ThreadLocal variable after completion
        responseMessageHolder.remove();
        logger.info("After completion called, response cleared");
    }

    public static SoapMessage getResponseMessage() {
        return responseMessageHolder.get();
    }

    public static void clear() {
        responseMessageHolder.remove();
    }
}
