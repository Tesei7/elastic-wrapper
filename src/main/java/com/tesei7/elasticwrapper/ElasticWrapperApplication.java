package com.tesei7.elasticwrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ElasticWrapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticWrapperApplication.class, args);
    }

    @Bean
    public RestTemplate elastic() {
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return new RestTemplate(clientHttpRequestFactory);
    }
}
