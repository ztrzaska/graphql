package pl.ztrzaska.graphql.mapper;

import org.mapstruct.Mapper;
import pl.ztrzaska.graphql.model.AuthorDto;
import pl.ztrzaska.graphql.entity.AuthorEntity;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(AuthorEntity author);
}
