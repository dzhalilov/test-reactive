package com.example.testreactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient dataClient() {
        return RestClient.builder()
                .requestFactory(new JdkClientHttpRequestFactory())
                .build();
    }
}
