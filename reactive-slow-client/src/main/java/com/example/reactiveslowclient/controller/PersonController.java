package com.example.reactiveslowclient.controller;

import com.example.reactiveslowclient.dto.PersonDto;
import com.example.reactiveslowclient.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/random")
    public Flux<PersonDto> getRandomPersons() {
        return personService.getRandomPersons()
                .delaySubscription(Duration.ofMillis(2000));
    }
}
