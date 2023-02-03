package com.ztrzaska.graphql.mapper;

import org.mapstruct.Mapper;
import com.ztrzaska.graphql.model.AuthorDto;
import com.ztrzaska.graphql.entity.AuthorEntity;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(AuthorEntity author);
}
