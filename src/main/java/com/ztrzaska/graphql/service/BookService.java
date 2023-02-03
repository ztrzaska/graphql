package com.ztrzaska.graphql.service;

import com.ztrzaska.graphql.entity.AuthorEntity;
import com.ztrzaska.graphql.entity.BookEntity;
import com.ztrzaska.graphql.mapper.BookMapper;
import com.ztrzaska.graphql.model.BookDto;
import com.ztrzaska.graphql.model.BookPageDto;
import com.ztrzaska.graphql.model.input.CreateBookInputDto;
import com.ztrzaska.graphql.repository.AuthorRepository;
import com.ztrzaska.graphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;
    private final Clock clock;

    public BookDto findById(UUID id) {
        BookEntity book = bookRepository.findById(id).orElse(null);
        log.info("Book with id: {} " + (book == null ? "not found" : "found"), id);

        return bookMapper.map(book);
    }

    public List<BookDto> findAll() {
        List<BookEntity> books = bookRepository.findAll();
        log.info("Retrieved books: {}", books.size());
        return bookMapper.map(books);
    }

    public BookPageDto findAll(PageRequest pageRequest) {
        log.info("Retrieving books paginated {}", LocalDateTime.now());
        Page<BookEntity> books = bookRepository.findAll(pageRequest);
        List<BookDto> mappedBooks = bookMapper.map(books);
        return BookPageDto.builder()
                .books(mappedBooks)
                .currentPage(books.getNumber())
                .totalPages(books.getTotalPages()).build();
    }

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
