package com.roger.service;

import com.roger.webservice.GetCountryRequest;
import com.roger.webservice.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

/**
 * @author Roger
 * @Description
 * @create 2024-07-26
 */
@Service
public class ClientService extends WebServiceGatewaySupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    public GetCountryResponse getCountryResponse(String name) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);

        GetCountryResponse response = null;
        try {
            WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
            response = (GetCountryResponse) webServiceTemplate.marshalSendAndReceive(request);
        } catch (Exception ex) {
            if (ex.getCause() instanceof ConnectException) {
                LOGGER.error("Connect error ...", ex);
            } else if (ex.getCause() instanceof SocketTimeoutException) {
                LOGGER.error("Read time out error ...", ex);
            } else {
                LOGGER.error("Other error ...", ex);
            }
        }

        return response;

    }
}
