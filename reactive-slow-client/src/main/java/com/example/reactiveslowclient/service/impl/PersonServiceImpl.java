package com.example.reactiveslowclient.service.impl;

import com.example.reactiveslowclient.dto.PersonDto;
import com.example.reactiveslowclient.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PersonServiceImpl implements PersonService {
    private final Random random = new Random();
    private final List<PersonDto> personList;

    public PersonServiceImpl() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("MOCK_DATA.json");
        personList = Arrays.asList(objectMapper.readValue(resource.getFile(), PersonDto[].class));
    }

    @Override
    public Flux<PersonDto> getRandomPersons() {
        String randomLetter = getRandomLetter();
        return getStartsFistName(randomLetter);
    }

    @Override
    public Flux<PersonDto> getStartsFistName(String firstNameLetter) {
        return Flux.fromIterable(personList)
                .filter(person -> person.firstName().startsWith(firstNameLetter));
    }

    private String getRandomLetter() {
        return String.valueOf((char) ('A' + random.nextInt(26)));
    }
}
