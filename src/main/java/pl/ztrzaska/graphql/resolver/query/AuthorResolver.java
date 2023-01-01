package pl.ztrzaska.graphql.resolver.query;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import pl.ztrzaska.graphql.domain.AuthorDto;
import pl.ztrzaska.graphql.domain.BookDto;

@Component
@Slf4j
public class AuthorResolver {

    @QueryMapping
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
