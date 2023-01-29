package com.ztrzaska.graphql.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDocument {

    @Id
    private String id;

    private String name;

    private String author;

    private List<String> comments;

    private Integer pageCount;

    private ArticleType type;

    private LocalDate releaseDate;

    private ZonedDateTime createdAt;
}
