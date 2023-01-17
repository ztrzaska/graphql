package com.ztrzaska.graphql.mapper;

import com.ztrzaska.graphql.domain.BookDto;
import com.ztrzaska.graphql.model.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto map(BookEntity author);

    List<BookDto> map(Iterable<BookEntity> author);
}
