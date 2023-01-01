package pl.ztrzaska.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import pl.ztrzaska.graphql.domain.BookDto;
import pl.ztrzaska.graphql.domain.BookPageDto;
import pl.ztrzaska.graphql.mapper.BookMapper;
import pl.ztrzaska.graphql.model.BookEntity;
import pl.ztrzaska.graphql.repository.BookRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class BookResolver  {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @QueryMapping
    public BookDto bookById(UUID id, DataFetchingEnvironment environment) {
        log.info("Retrieving new book id: {}", id);

        //reading query parameters
        //environment.getSelectionSet().getFields().stream().collect(Collectors.toUnmodifiableSet());

        BookEntity book = bookRepository.findById(id).orElse(null);
        return bookMapper.map(book);
    }

    @QueryMapping
    public List<BookDto> books(DataFetchingEnvironment environment) {
        log.info("Retrieving books {}", LocalDateTime.now());
        Iterable<BookEntity> books = bookRepository.findAll();
        return bookMapper.map(books);
    }

    @QueryMapping
    public BookPageDto booksPaginated(int pageNumber, int pageSize) {
        log.info("Retrieving books paginated {}", LocalDateTime.now());

        Page<BookEntity> books = bookRepository.findAll(PageRequest.of(pageNumber, pageSize));
        List<BookDto> mappedBooks = bookMapper.map(books);
        return BookPageDto.builder()
                .books(mappedBooks)
                .currentPage(books.getNumber())
                .totalPages(books.getTotalPages()).build();
    }

}