package com.example.testreactive.service

import com.example.testreactive.dto.PersonDto

interface PersonService {
    suspend fun getRandomPersons(): List<PersonDto>
    suspend fun getFastRandomPersons(): List<PersonDto>
    suspend fun getSlowRandomPersons(): List<PersonDto>
    suspend fun getStartsFistName(firstNameLetter: String): List<PersonDto>
}
