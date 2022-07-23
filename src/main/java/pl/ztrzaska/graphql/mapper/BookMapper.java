package pl.ztrzaska.graphql.mapper;

import org.mapstruct.Mapper;
import pl.ztrzaska.graphql.domain.BookDto;
import pl.ztrzaska.graphql.model.BookEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto map(BookEntity author);

    List<BookDto> map(Iterable<BookEntity> author);
}
