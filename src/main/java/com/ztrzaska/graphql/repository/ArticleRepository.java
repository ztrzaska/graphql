package com.ztrzaska.graphql.repository;

import com.ztrzaska.graphql.document.ArticleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<ArticleDocument, String> {

}
