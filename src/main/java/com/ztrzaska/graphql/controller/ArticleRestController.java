package com.ztrzaska.graphql.controller;

import com.ztrzaska.graphql.model.ArticleDto;
import com.ztrzaska.graphql.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleRestController {

    private final ArticleService articleService;

    @CrossOrigin
    @GetMapping("/articles")
    public List<ArticleDto> articles() {
        return articleService.findAll();
    }
}
