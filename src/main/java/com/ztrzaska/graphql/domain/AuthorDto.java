package com.ztrzaska.graphql.domain;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class AuthorDto {

    UUID id;
    String firstName;
    String lastName;

}
