package com.roger.controller;

import com.roger.service.ClientService;
import com.roger.webservice.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Roger
 * @Description
 * @create 2024-07-26
 */
@RequestMapping
@RestController
public class Controller {

    @Autowired
    private ClientService client;

    @GetMapping("/getCountry")
    public ResponseEntity<GetCountryResponse> getCountry(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(client.getCountryResponse(name));
    }
}
