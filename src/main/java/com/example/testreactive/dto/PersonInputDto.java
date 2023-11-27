package com.example.testreactive.dto;

public record PersonInputDto(
    Long id,
    String firstName,
    String lastName,
    String email,
    String gender,
    String ipAddress
) {
}
