package com.example.reactivefastclient.controller;

import com.example.reactivefastclient.dto.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class InfoController {

    @GetMapping(value = "/info")
    public Mono<Info> getInfo() {
        return Mono.just(Thread.currentThread().getName())
                .delayElement(Duration.ofMillis(200))
                .map(s -> new Info("FAST: " + s));
    }
}
