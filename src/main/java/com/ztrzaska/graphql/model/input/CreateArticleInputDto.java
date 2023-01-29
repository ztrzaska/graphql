package com.ztrzaska.graphql.model.input;

import com.ztrzaska.graphql.document.ArticleType;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateArticleInputDto {

    @NotEmpty
    String name;
    @Min(10)
    Integer pageCount;
    ArticleType type;
    LocalDate releaseDate;
    @NotNull
    String author;
}
