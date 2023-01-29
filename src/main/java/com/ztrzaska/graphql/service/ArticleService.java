package com.ztrzaska.graphql.service;

import com.ztrzaska.graphql.document.ArticleDocument;
import com.ztrzaska.graphql.mapper.ArticleMapper;
import com.ztrzaska.graphql.model.ArticleDto;
import com.ztrzaska.graphql.model.input.CreateArticleInputDto;
import com.ztrzaska.graphql.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.OffsetDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;
    private final Clock clock;

    public ArticleDto create(CreateArticleInputDto articleInput) {
        log.info("Creating new article for {}", articleInput);


        ArticleDocument articleDocument = ArticleDocument.builder()
                .name(articleInput.getName())
                .type(articleInput.getType())
                .author(articleInput.getAuthor())
                .pageCount(articleInput.getPageCount())
                .comments(articleInput.getComments())
                .releaseDate(articleInput.getReleaseDate())
                .createdAt(OffsetDateTime.now(clock))
                .build();
        articleDocument = articleRepository.save(articleDocument);

        return articleMapper.map(articleDocument);
    }
}
