package com.example.testreactive.dto;


public record PersonDto(
    String firstName,
    String lastName,
    String email,
    String gender,
    String ipAddress
) {
}
