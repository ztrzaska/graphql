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
import java.time.Instant;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;
    private final Clock clock;

    public ArticleDocument findById(String id) {
        ArticleDocument article = articleRepository.findById(id).orElse(null);
        log.info("Article with id: {} " + (article == null ? "not found" : "found"), id);
        return article;
    }

    public List<ArticleDocument> findAll() {
        List<ArticleDocument> articles = articleRepository.findAll();
        log.info("Retrieved article: {}", articles.size());
        return articles;
    }

    public ArticleDto create(CreateArticleInputDto articleInput) {
        log.info("Creating article for {}", articleInput);

        ArticleDocument articleDocument = ArticleDocument.builder()
                .name(articleInput.getName())
                .type(articleInput.getType())
                .author(articleInput.getAuthor())
                .pageCount(articleInput.getPageCount())
                .comments(articleInput.getComments())
                .releaseDate(articleInput.getReleaseDate())
                .createdAt(Instant.now(clock))
                .build();
        articleDocument = articleRepository.save(articleDocument);

        return articleMapper.map(articleDocument);
    }

}
