package com.example.testreactive.service.impl;

import com.example.testreactive.dto.PersonDto;
import com.example.testreactive.dto.PersonInputDto;
import com.example.testreactive.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class PersonServiceImpl implements PersonService {

    private final RestClient dataClient;

    @Autowired
    public PersonServiceImpl(RestClient dataClient) {
        this.dataClient = dataClient;
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
        return Arrays.stream(Objects.requireNonNull(dataClient.get()
                        .uri("http://localhost:8081/persons/random")
                        .retrieve()
                        .body(PersonInputDto[].class)))
                .map(this::toPersonDto)
                .toList();
    }

    @Override
    public List<PersonDto> getSlowRandomPersons() {
        return Arrays.stream(Objects.requireNonNull(dataClient.get()
                        .uri("http://localhost:8082/persons/random")
                        .retrieve()
                        .body(PersonInputDto[].class)))
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
