package pl.ztrzaska.graphql.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.ztrzaska.graphql.model.BookEntity;

import java.util.UUID;

@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity, UUID> {

}
