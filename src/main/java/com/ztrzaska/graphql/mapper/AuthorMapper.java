package com.ztrzaska.graphql.mapper;

import com.ztrzaska.graphql.model.AuthorDto;
import com.ztrzaska.graphql.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(AuthorEntity author);
}
