package com.roger.webservice;

import com.roger.service.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author 2407009
 * @Description
 * @create 2024-07-26
 */
@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://roger.com/webservice";

    @Autowired
    private CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    public @ResponsePayload
    GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
