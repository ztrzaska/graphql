package com.ztrzaska.graphql.model.input;

import lombok.Data;
import com.ztrzaska.graphql.entity.Genre;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateBookInputDto {

    @NotEmpty
    String name;
    @Min(10)
    Integer pageCount;
    Genre genre;
    LocalDate releaseDate;
    @NotNull
    UUID authorId;
}
