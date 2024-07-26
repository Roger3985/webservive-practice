package com.roger.service;

import com.roger.webservice.Country;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface CountryService {

    @WebMethod
    Country getCountry(String name);
}
