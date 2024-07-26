package com.roger;

import com.roger.service.impl.HelloServiceImpl;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Roger
 * @Description
 * @create 2024-07-26
 */
public class Server {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        // 發布服務的工廠
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();

        // 設置服務地址
        factoryBean.setAddress("http://localhost:8000/ws/hello");

        // 設置服務類
        factoryBean.setServiceBean(new HelloServiceImpl());

        // 添加日誌輸入，輸出攔截器，觀察 soap 請求以及 soap 回應的內容
        factoryBean.getInInterceptors().add(new LoggingInInterceptor());
        factoryBean.getOutInterceptors().add(new LoggingInInterceptor());

        // 發布服務
        factoryBean.create();

        logger.info("發布服務成功，端口 8000");
        System.out.println("發布服務成功，端口 8000");
    }
}
