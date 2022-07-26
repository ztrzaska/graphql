package pl.ztrzaska.graphql.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.ztrzaska.graphql.domain.BookDto;
import pl.ztrzaska.graphql.domain.input.CreateBookInputDto;
import pl.ztrzaska.graphql.mapper.BookMapper;
import pl.ztrzaska.graphql.model.AuthorEntity;
import pl.ztrzaska.graphql.model.BookEntity;
import pl.ztrzaska.graphql.repository.AuthorRepository;
import pl.ztrzaska.graphql.repository.BookRepository;

import java.time.Clock;
import java.time.ZonedDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;
    private final Clock clock;

    public BookDto create(CreateBookInputDto bookInput) {
        log.info("Creating new book for {}", bookInput);

        AuthorEntity author = authorRepository.findById(bookInput.getAuthorId())
                .orElseThrow(() -> new UnsupportedOperationException("Author not exists"));

        BookEntity bookEntity = BookEntity.builder()
                .author(author)
                .name(bookInput.getName())
                .pageCount(bookInput.getPageCount())
                .genre(bookInput.getGenre())
                .releaseDate(bookInput.getReleaseDate())
                .createdAt(ZonedDateTime.now(clock))
                .build();
        bookEntity = bookRepository.save(bookEntity);

        return bookMapper.map(bookEntity);
    }
}
