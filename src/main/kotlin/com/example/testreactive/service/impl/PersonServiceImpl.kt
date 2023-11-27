package com.example.testreactive.service.impl

import com.example.testreactive.dto.PersonDto
import com.example.testreactive.dto.PersonInputDto
import com.example.testreactive.service.PersonService
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Service
class PersonServiceImpl (webClientBuilder: WebClient.Builder) : PersonService {
    private val webClient: WebClient = webClientBuilder.build()

    override suspend fun getRandomPersons(): List<PersonDto> {
        return coroutineScope {
            val fastRandomPersons = async { getFastRandomPersons() }
            val slowRandomPersons = async { getSlowRandomPersons() }
            fastRandomPersons.await() + slowRandomPersons.await()
        }
    }

    override suspend fun getFastRandomPersons(): List<PersonDto> = webClient.get()
        .uri("http://localhost:8081/persons/random")
        .retrieve()
        .awaitBody<List<PersonInputDto>>()
        .map { it.toPersonDto() }

    override suspend fun getSlowRandomPersons(): List<PersonDto> = webClient.get()
        .uri("http://localhost:8082/persons/random")
        .retrieve()
        .awaitBody<List<PersonInputDto>>()
        .map { it.toPersonDto() }

    override suspend fun getStartsFistName(firstNameLetter: String): List<PersonDto> {
        return listOf()
    }

    fun PersonInputDto.toPersonDto(): PersonDto {
        return PersonDto(
            firstName,
            lastName,
            email,
            if (gender == "Male" || gender == "Female") gender else "Unknown",
            ipAddress
        )
    }
}
