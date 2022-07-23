package pl.ztrzaska.graphql.domain;

import lombok.Builder;
import lombok.Value;
import pl.ztrzaska.graphql.model.Genre;

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
