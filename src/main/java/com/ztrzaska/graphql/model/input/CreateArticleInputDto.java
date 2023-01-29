package com.ztrzaska.graphql.model.input;

import com.ztrzaska.graphql.document.ArticleType;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class CreateArticleInputDto {

    @NotEmpty
    String name;
    ArticleType type;
    @NotNull
    String author;
    @Min(1)
    Integer pageCount;
    List<String> comments;
    LocalDate releaseDate;

}
