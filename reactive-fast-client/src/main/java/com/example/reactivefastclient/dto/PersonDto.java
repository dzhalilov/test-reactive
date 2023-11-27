package com.example.reactivefastclient.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record PersonDto(
    Long id,

    @JsonAlias("first_name")
    String firstName,
    @JsonAlias("last_name")
    String lastName,
    String email,
    String gender,
    @JsonAlias("ip_address")
    String ipAddress
) {
}
