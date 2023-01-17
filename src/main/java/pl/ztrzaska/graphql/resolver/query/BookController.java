package pl.ztrzaska.graphql.resolver.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pl.ztrzaska.graphql.domain.BookDto;
import pl.ztrzaska.graphql.domain.BookPageDto;
import pl.ztrzaska.graphql.mapper.BookMapper;
import pl.ztrzaska.graphql.model.BookEntity;
import pl.ztrzaska.graphql.repository.BookRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @QueryMapping
    public BookDto bookById(@Argument UUID id) {
        log.info("Retrieving new book id: {}", id);

        BookEntity book = bookRepository.findById(id).orElse(null);
        return bookMapper.map(book);
    }

    @QueryMapping
    public List<BookDto> books() {
        log.info("Retrieving books {}", LocalDateTime.now());
        Iterable<BookEntity> books = bookRepository.findAll();
        return bookMapper.map(books);
    }

    @QueryMapping
    public BookPageDto booksPaginated(@Argument int pageNumber, @Argument int pageSize) {
        log.info("Retrieving books paginated {}", LocalDateTime.now());

        Page<BookEntity> books = bookRepository.findAll(PageRequest.of(pageNumber, pageSize));
        List<BookDto> mappedBooks = bookMapper.map(books);
        return BookPageDto.builder()
                .books(mappedBooks)
                .currentPage(books.getNumber())
                .totalPages(books.getTotalPages()).build();
    }

}