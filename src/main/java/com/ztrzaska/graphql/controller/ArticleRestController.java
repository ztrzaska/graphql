package com.ztrzaska.graphql.controller;

import com.ztrzaska.graphql.model.ArticleDto;
import com.ztrzaska.graphql.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ArticleRestController {

    private final ArticleService articleService;

    @CrossOrigin
    @GetMapping("/articles")
    public List<ArticleDto> articles() {
        log.info("Retrieving all articles");
        return articleService.findAll();
    }
}
