package com.ztrzaska.graphql.mapper;

import com.ztrzaska.graphql.model.BookDto;
import com.ztrzaska.graphql.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto map(BookEntity author);

    List<BookDto> map(Iterable<BookEntity> author);
}
