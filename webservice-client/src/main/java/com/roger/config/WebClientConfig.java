package com.roger.config;

import com.roger.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

/**
 * @author Roger
 * @Description
 * @create 2024-07-26
 */
@Configuration
public class WebClientConfig {

    @Autowired
    private ClientService clientService;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.roger.webservice");
        return marshaller;
    }

    @Bean
    public WebServiceMessageSender webServiceMessageSender() {
        HttpComponentsMessageSender sender = new HttpComponentsMessageSender();
        sender.setConnectionTimeout(5 * 1000);
        sender.setReadTimeout(5 * 1000);
        return sender;
    }

    @Bean
    @Primary
    public ClientService wsClient(Jaxb2Marshaller marshaller, WebServiceMessageSender sender) {
        clientService.setDefaultUri("http://localhost:8081/ws/countries");
        clientService.setMarshaller(marshaller);
        clientService.setUnmarshaller(marshaller);
        clientService.setMessageSender(sender);
        return clientService;
    }
}
