package pl.ztrzaska.graphql.controller.mutation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import pl.ztrzaska.graphql.model.BookDto;
import pl.ztrzaska.graphql.model.input.CreateBookInputDto;
import pl.ztrzaska.graphql.service.BookService;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BookMutation {

    private final BookService bookService;

    @MutationMapping
    public BookDto createBook(@Argument(name = "input") @Valid CreateBookInputDto bookInput) {
        return bookService.create(bookInput);
    }
}
