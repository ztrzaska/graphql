package com.ztrzaska.graphql.controller.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.ContextValue;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import com.ztrzaska.graphql.model.AuthorDto;
import com.ztrzaska.graphql.model.BookDto;
import com.ztrzaska.graphql.model.BookPageDto;
import com.ztrzaska.graphql.service.BookService;

import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @QueryMapping
    public BookDto bookById(@Argument UUID id, @ContextValue String version) {
        log.info("Retrieving book with id: {}", id);
        return bookService.findById(id);
    }

    @QueryMapping
    public List<BookDto> books() {
        log.info("Retrieving all books");
        return bookService.findAll();
    }

    @QueryMapping
    public BookPageDto booksPaginated(@Argument int pageNumber, @Argument int pageSize) {
        log.info("Retrieving paginated books");
        return bookService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @SchemaMapping(typeName = "Book", field = "author")
    public AuthorDto author(BookDto book) {
        return book.getAuthor();
    }

}