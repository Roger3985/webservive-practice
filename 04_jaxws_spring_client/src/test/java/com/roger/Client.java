package com.roger;

import com.roger.service.HelloService;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Roger
 * @Description
 * @create 2024-07-27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Client {

    // 注入物件（搭配 JAX-WS 的 spring bean 的注入方式）
    @Resource
    private HelloService helloService;

    @Test
    public void remote() {
        // 查看介面的代件類型
        // class jdk.proxy2.$Proxy50
        System.out.println(helloService.getClass());

        // 遠程訪問服務端方法
        System.out.println(helloService.sayHello("Jerry"));
    }
}
