package com.example.reactivefastclient.service;

import com.example.reactivefastclient.dto.PersonDto;
import reactor.core.publisher.Flux;

public interface PersonService {
    Flux<PersonDto> getRandomPersons();

    Flux<PersonDto> getStartsFistName(String firstNameLetter);
}
