package com.example.testreactive.service.impl;

import com.example.testreactive.dto.PersonDto;
import com.example.testreactive.dto.PersonInputDto;
import com.example.testreactive.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class PersonServiceImpl implements PersonService {

    private final WebClient webClient;


    @Autowired
    public PersonServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }


    @Override
    public Flux<PersonDto> getRandomPersons() {
        return getFastRandomPersons().concatWith(getSlowRandomPersons());
    }

    @Override
    public Flux<PersonDto> getFastRandomPersons() {
        return webClient.get()
                .uri("http://localhost:8081/persons/random")
                .retrieve()
                .bodyToFlux(PersonInputDto.class)
                .map(this::toPersonDto);
    }

    @Override
    public Flux<PersonDto> getSlowRandomPersons() {
        return webClient.get()
                .uri("http://localhost:8082/persons/random")
                .retrieve()
                .bodyToFlux(PersonInputDto.class)
                .map(this::toPersonDto);
    }

    @Override
    public Flux<PersonDto> getStartsFistName(String firstNameLetter) {
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
