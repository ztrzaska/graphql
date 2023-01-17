package com.ztrzaska.graphql.mapper;

import com.ztrzaska.graphql.domain.AuthorDto;
import com.ztrzaska.graphql.model.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(AuthorEntity author);
}
