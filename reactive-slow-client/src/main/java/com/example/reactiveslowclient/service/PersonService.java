package com.example.reactiveslowclient.service;

import com.example.reactiveslowclient.dto.PersonDto;
import reactor.core.publisher.Flux;

public interface PersonService {
    Flux<PersonDto> getRandomPersons();

    Flux<PersonDto> getStartsFistName(String firstNameLetter);
}
