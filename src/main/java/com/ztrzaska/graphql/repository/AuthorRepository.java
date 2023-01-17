package com.ztrzaska.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ztrzaska.graphql.model.AuthorEntity;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorEntity, UUID> {
}
