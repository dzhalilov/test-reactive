package com.example.reactiveslowclient.controller;

import com.example.reactiveslowclient.dto.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class InfoController {

    @GetMapping(value = "/info")
    public Mono<Info> getInfo() {
        Info info = new Info("SLOW: " + Thread.currentThread().getName());
        return Mono.just(info)
                .delayElement(Duration.ofMillis(2000));
    }
}
