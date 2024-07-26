package com.roger.service;

import jakarta.jws.WebService;

/**
 * @author Roger
 * @Description 對外發布的介面。
 * @create 2024-07-26
 */
@WebService
public interface HelloService {

    /**
     * 對外發布服務的介面的方法
     */
    public String sayHello(String name);

}
