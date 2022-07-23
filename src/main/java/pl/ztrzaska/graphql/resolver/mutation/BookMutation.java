package pl.ztrzaska.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import pl.ztrzaska.graphql.domain.BookDto;
import pl.ztrzaska.graphql.domain.input.CreateBookInputDto;
import pl.ztrzaska.graphql.service.BookService;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Validated
@Component
public class BookMutation implements GraphQLMutationResolver {

    private final BookService bookService;

    public BookDto createBook(@Valid CreateBookInputDto bookInput) {
        return bookService.create(bookInput);
    }
}
