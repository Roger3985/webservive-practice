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

    /**
     * Jaxb2Marshaller：
     * 我們為序列化工具設定 Jaxb 物件（Java Architecture for XML Binding，
     * 將 Java 類映射為 XML 的表示方式）的位置，
     * 也就是方才我們從 wsdl 生成 Java物件的資料夾路徑。
     * @return Jaxb2Marshaller。
     */
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.roger.webservice");
        return marshaller;
    }

    /**
     * WebServiceMessageSender：
     * 為了避免等待 Server 端連線或是回應時間過長導致後續流程受阻，
     * 這裡用 WebServiceMessageSender 的實作類 HttpComponentsMessageSender 來控制等待的時間，
     * setConnectionTimeout 表示與 Server 建立連線時的等待時間、setReadTimeout 表示等待 Server 回應的時間，
     * 單位都是毫秒（milliseconds）。
     * @return WebServiceMessageSender。
     */
    @Bean
    public WebServiceMessageSender webServiceMessageSender() {
        HttpComponentsMessageSender sender = new HttpComponentsMessageSender();
        sender.setConnectionTimeout(5 * 1000);
        sender.setReadTimeout(5 * 1000);
        return sender;
    }

    /**
     * 接者將以上配置設定到 Client 物件：
     * setDefaultUri 設定 Server 端的地址，
     * 即與 wsdl <soap:address location>的值相同 ；
     * setMarshaller、setUnmarshaller 設定序列化工具；
     * setMessageSender 設定逾時時間；
     * 至於 setInterceptors 則是為了印出 SOAP 訊息所加的攔截器。
     * @param marshaller setMarshaller。
     * @param sender setMessageSender。
     * @return ClientService 物件。
     */
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
