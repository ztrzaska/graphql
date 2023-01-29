package com.ztrzaska.graphql.controller;

import com.ztrzaska.graphql.document.ArticleDocument;
import com.ztrzaska.graphql.mapper.ArticleMapper;
import com.ztrzaska.graphql.model.ArticleDto;
import com.ztrzaska.graphql.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @QueryMapping
    public ArticleDto articleById(@Argument String id) {
        log.info("Retrieving new article id: {}", id);

        ArticleDocument article = articleRepository.findById(id).orElse(null);
        return articleMapper.map(article);
    }

    @QueryMapping
    public List<ArticleDto> articles() {
        log.info("Retrieving articles {}", LocalDateTime.now());
        Iterable<ArticleDocument> articles = articleRepository.findAll();
        return articleMapper.map(articles);
    }


    @SchemaMapping(typeName = "Article", field = "author")
    public String author(ArticleDto article) {
        return article.getAuthor();
    }

}