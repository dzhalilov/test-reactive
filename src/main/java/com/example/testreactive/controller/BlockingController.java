package com.example.testreactive.controller;

import com.example.testreactive.dto.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/block", produces = MediaType.APPLICATION_JSON_VALUE)
public class BlockingController {
    private final RestTemplate restTemplate;

    @Autowired
    public BlockingController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @GetMapping("/fast")
    public Info getFromFastClient() {
        return restTemplate.exchange("http://localhost:8081/info", HttpMethod.GET, null, Info.class)
                .getBody();
    }

    @GetMapping("/slow")
    public Info getFromSlowClient() {
        return restTemplate.exchange("http://localhost:8082/info", HttpMethod.GET, null, Info.class)
                .getBody();
    }
}
