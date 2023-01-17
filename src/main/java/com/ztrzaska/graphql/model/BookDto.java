package com.ztrzaska.graphql.model;

import com.ztrzaska.graphql.entity.Genre;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Value
@Builder
public class BookDto {

    UUID id;
    String name;
    Integer pageCount;
    Genre genre;
    AuthorDto author;
    LocalDate releaseDate;
    ZonedDateTime createdAt;

}
