package com.example.testreactive.controller;

//import com.example.testreactive.dto.Info;
import org.springframework.http.MediaType;
//import org.springframework.http.client.reactive.ReactorClientHttpConnector;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//import reactor.netty.http.client.HttpClient;
//import reactor.netty.resources.ConnectionProvider;

@RestController
@RequestMapping(value = "/reactive", produces = MediaType.APPLICATION_NDJSON_VALUE)
public class ReactiveController {

//    private final WebClient webClient;
//
//    public ReactiveController(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder
//                .clientConnector(
//                        new ReactorClientHttpConnector(
//                                HttpClient.create(
//                                        ConnectionProvider.builder("Custom")
//                                                .maxConnections(10000)
//                                                .build()
//                                )
//                        )
//                )
//                .build();
//    }
//
//    @GetMapping("/fast")
//    public Mono<Info> getFromFastClient() {
//        return webClient.get()
//                .uri("http://localhost:8081/info")
//                .retrieve()
//                .bodyToMono(Info.class);
//    }
//
//    @GetMapping("/slow")
//    public Mono<Info> getFromSlowClient() {
//        return webClient.get()
//                .uri("http://localhost:8082/info")
//                .retrieve()
//                .bodyToMono(Info.class);
//    }
}
