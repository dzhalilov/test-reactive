package com.example.testreactive.dto

data class PersonInputDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val gender: String,
    val ipAddress: String
)
