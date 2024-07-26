package com.roger;

import com.roger.service.HelloService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @author Roger
 * @Description
 * @create 2024-07-26
 */
public class Client {
    public static void main(String[] args) {
        // 服務介面訪問地址：http://localhost:8000/ws/hello

        // 創建 cxf 代理工廠
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();

        // 設置遠程訪問服務端的地址
        factoryBean.setAddress("http://localhost:8000/ws/hello");

        // 設置介面類型
        factoryBean.setServiceClass(HelloService.class);

        // 對介面生成代理物件
        HelloService helloService = factoryBean.create(HelloService.class);

        // 代理物件類型 class jdk.proxy2.$Proxy37 [Java代理： 1.靜態代理; 2.動態代理（jdk介面代理、cglib子類代理($CGLIB123...））]
        System.out.println(helloService.getClass());

        // 遠程訪問服務端方法
        String content = helloService.sayHello("Jet");
        System.out.println(content);
    }
}
