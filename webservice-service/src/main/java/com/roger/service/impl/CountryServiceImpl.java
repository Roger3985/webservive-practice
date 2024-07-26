package com.roger.service.impl;

import com.roger.service.CountryService;
import com.roger.webservice.Country;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceImpl implements CountryService {

    @Autowired
    private Country country = new Country();

    @Override
    public Country getCountry(String name) {
        // 邏輯實現
        return country;
    }
}
