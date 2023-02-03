package com.ztrzaska.graphql.resolver.query;

import com.ztrzaska.graphql.model.BookDto;
import com.ztrzaska.graphql.model.BookPageDto;
import com.ztrzaska.graphql.service.BookService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class BookResolver implements GraphQLQueryResolver {

    private final BookService bookService;

    public BookDto bookById(UUID id, DataFetchingEnvironment environment) {
        log.info("Retrieving all books");

        //reading query parameters
        //environment.getSelectionSet().getFields().stream().collect(Collectors.toUnmodifiableSet());

        return bookService.findById(id);
    }

    public List<BookDto> books(DataFetchingEnvironment environment) {
        log.info("Retrieving books {}", LocalDateTime.now());
        return bookService.findAll();
    }

    public BookPageDto booksPaginated(int pageNumber, int pageSize) {
        log.info("Retrieving paginated books");
        return bookService.findAll(PageRequest.of(pageNumber, pageSize));
    }

}