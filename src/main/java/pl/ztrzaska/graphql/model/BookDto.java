package pl.ztrzaska.graphql.model;

import lombok.Builder;
import lombok.Value;
import pl.ztrzaska.graphql.entity.Genre;

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
