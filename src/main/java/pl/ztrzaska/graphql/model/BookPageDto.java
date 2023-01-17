package pl.ztrzaska.graphql.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class BookPageDto {

    List<BookDto> books;
    int totalPages;
    int currentPage;
}
