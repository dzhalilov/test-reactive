package com.example.testreactive.service.impl;

import com.example.testreactive.dto.PersonDto;
import com.example.testreactive.dto.PersonInputDto;
import com.example.testreactive.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class PersonServiceImpl implements PersonService {

    private final RestTemplate restTemplate;


    @Autowired
    public PersonServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }


    @Override
    public List<PersonDto> getRandomPersons() {
        return Stream.of(
                        getFastRandomPersons(),
                        getSlowRandomPersons()
                )
                .flatMap(List::stream)
                .toList();
    }

    @Override
    public List<PersonDto> getFastRandomPersons() {
        return Stream.of(
                        Objects.requireNonNull(
                                restTemplate.getForObject("http://localhost:8081/persons/random", PersonInputDto[].class)
                        )
                )
                .map(this::toPersonDto)
                .toList();
    }

    @Override
    public List<PersonDto> getSlowRandomPersons() {
        return Stream.of(
                        Objects.requireNonNull(
                                restTemplate.getForObject("http://localhost:8082/persons/random", PersonInputDto[].class)
                        )
                )
                .map(this::toPersonDto)
                .toList();
    }

    @Override
    public List<PersonDto> getStartsFistName(String firstNameLetter) {
        return null;
    }

    private PersonDto toPersonDto(PersonInputDto personInputDto) {
        String gender = personInputDto.gender();
        return new PersonDto(
                personInputDto.firstName(),
                personInputDto.lastName(),
                personInputDto.email(),
                gender.equals("Male") || gender.equals("Female") ? gender : "Unknown",
                personInputDto.ipAddress()
        );
    }
}
