package com.ztrzaska.graphql.controller;

import com.ztrzaska.graphql.model.ArticleDto;
import com.ztrzaska.graphql.model.input.CreateArticleInputDto;
import com.ztrzaska.graphql.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @QueryMapping
    public ArticleDto articleById(@Argument String id) {
        log.info("Retrieving article id: {}", id);
        return articleService.findById(id);
    }

    @QueryMapping
    public List<ArticleDto> articles() {
        log.info("Retrieving all articles");
        return articleService.findAll();
    }

    @SchemaMapping(typeName = "Article", field = "author")
    public String author(ArticleDto article) {
        return article.getAuthor();
    }


    @MutationMapping
    public ArticleDto createArticle(@Argument(name = "input") @Valid CreateArticleInputDto articleInput) {
        return articleService.create(articleInput);
    }
}