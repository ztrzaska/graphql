package com.ztrzaska.graphql.model;

import com.ztrzaska.graphql.document.ArticleType;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Value
@Builder
public class ArticleDto {

    String id;
    String name;
    Integer pageCount;
    ArticleType type;
    String author;
    LocalDate releaseDate;
    OffsetDateTime createdAt;

}
