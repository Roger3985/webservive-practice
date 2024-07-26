package com.roger.service.impl;

import com.roger.service.CountryService;


public class CountryServiceImpl implements CountryService {
    @Override
    public String getCountry(String name) {
        // 邏輯實現
        return "Country into for " + name;
    }
}
