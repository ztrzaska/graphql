package com.ztrzaska.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.ztrzaska.graphql.domain.AuthorDto;
import com.ztrzaska.graphql.domain.BookDto;

@Component
@Slf4j
public class AuthorResolver implements GraphQLResolver<BookDto> {

    public AuthorDto author(BookDto book) {
        log.info("Retrieving new book id: {}", book.getId() );
        AuthorDto author = book.getAuthor();

        return AuthorDto.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .build();
    }
}
