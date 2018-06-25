package com.tesei7.elasticwrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ElasticWrapperController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "*", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRequest(HttpServletRequest request, HttpEntity<String> httpEntity) {
        return restTemplate
                .exchange("http://127.0.0.1:9200" + request.getRequestURI(), HttpMethod.GET, httpEntity, String.class)
                .getBody();
    }
}
