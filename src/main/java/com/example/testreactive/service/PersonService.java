package com.example.testreactive.service;

import com.example.testreactive.dto.PersonDto;

import java.util.List;

public interface PersonService {
    List<PersonDto> getRandomPersons();
    List<PersonDto> getFastRandomPersons();
    List<PersonDto> getSlowRandomPersons();

    List<PersonDto> getStartsFistName(String firstNameLetter);
}
