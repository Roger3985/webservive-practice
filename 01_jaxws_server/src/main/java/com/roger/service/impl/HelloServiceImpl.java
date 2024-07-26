package com.roger.service.impl;

import com.roger.service.HelloService;
import jakarta.jws.WebService;

/**
 * @author Roger
 * @Description
 * @create 2024-07-26
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + "，Welcome to Roger Home.";
    }
}
