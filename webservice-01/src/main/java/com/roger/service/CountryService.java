package com.roger.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface CountryService {

    @WebMethod
    String getCountry(String name);
}
