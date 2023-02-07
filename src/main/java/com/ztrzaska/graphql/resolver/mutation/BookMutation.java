package com.ztrzaska.graphql.resolver.mutation;

import com.ztrzaska.graphql.model.BookDto;
import com.ztrzaska.graphql.model.input.CreateBookInputDto;
import com.ztrzaska.graphql.service.BookService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Component
public class BookMutation implements GraphQLMutationResolver {

    private final BookService bookService;

    public BookDto createBook(@Valid CreateBookInputDto bookInput) {
        return bookService.create(bookInput);
    }
}
