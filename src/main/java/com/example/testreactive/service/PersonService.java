package com.example.testreactive.service;

import com.example.testreactive.dto.PersonDto;
import reactor.core.publisher.Flux;

public interface PersonService {
    Flux<PersonDto> getRandomPersons();
    Flux<PersonDto> getFastRandomPersons();
    Flux<PersonDto> getSlowRandomPersons();

    Flux<PersonDto> getStartsFistName(String firstNameLetter);
}
