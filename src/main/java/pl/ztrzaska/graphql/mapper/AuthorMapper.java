package pl.ztrzaska.graphql.mapper;

import org.mapstruct.Mapper;
import pl.ztrzaska.graphql.domain.AuthorDto;
import pl.ztrzaska.graphql.model.AuthorEntity;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto map(AuthorEntity author);
}
