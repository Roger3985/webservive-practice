package com.roger;

import com.roger.service.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @author Roger
 * @Description
 * @create 2024-07-26
 */
public class Server {
    public static void main(String[] args) {
        // 發布服務的工廠
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();

        // 設置服務地址
        factoryBean.setAddress("http://localhost:8000/ws/hello");

        // 設置服務類
        factoryBean.setServiceBean(new HelloServiceImpl());

        // 發布服務
        factoryBean.create();

        System.out.println("發布服務成功，端口 8000");
    }
}
