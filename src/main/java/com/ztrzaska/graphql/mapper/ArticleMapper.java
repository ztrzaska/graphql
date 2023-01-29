package com.ztrzaska.graphql.mapper;

import com.ztrzaska.graphql.model.ArticleDto;
import com.ztrzaska.graphql.document.ArticleDocument;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    @Mapping(source = "id", target = "id")
    ArticleDto map(ArticleDocument article);

    List<ArticleDto> map(Iterable<ArticleDocument> articles);
}
