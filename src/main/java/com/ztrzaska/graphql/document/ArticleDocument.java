package com.ztrzaska.graphql.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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

    private ArticleType type;

    private String author;

    private Integer pageCount;

    private List<String> comments;

    private LocalDate releaseDate;

    private LocalDateTime createdAt;
}
