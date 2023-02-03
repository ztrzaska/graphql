package pl.ztrzaska.graphql.controller.query;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;
import pl.ztrzaska.graphql.config.ScalarConfiguration;
import pl.ztrzaska.graphql.model.BookDto;
import pl.ztrzaska.graphql.service.BookService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.doReturn;

@Import({ScalarConfiguration.class})
@GraphQlTest
class BookControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private BookService bookServiceMock;

    @Test
    @DisplayName("Test all books graphql query")
    void testBooksQuery() throws URISyntaxException, IOException {
        String queryContent = Files.readString(Paths.get(getClass().getClassLoader()
                .getResource("books_query.graphqls").toURI()));

        List<BookDto> books = List.of(createBook());
        doReturn(books).when(bookServiceMock).findAll();

        graphQlTester.document(queryContent)
            .execute()
            .path("books")
            .entityList(BookDto.class)
            .hasSizeGreaterThan(0);
    }

    private BookDto createBook() {
        return BookDto.builder()
                .id(UUID.fromString("6e09d978-a3e9-11ed-a8fc-0242ac120002"))
                .name("Harry Potter")
                .pageCount(200)
                .build();
    }
}