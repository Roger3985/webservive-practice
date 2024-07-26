package com.roger.webservice;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 2407009
 * @Description
 * @create 2024-07-26
 */
@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country harryPotterI = new Country();
        harryPotterI.setCapital("巴黎");
        harryPotterI.setName("法國");;
        harryPotterI.setCurrency(Currency.EUR);
        harryPotterI.setPopulation(198555);


        countries.put(harryPotterI.getName(), harryPotterI);
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}
