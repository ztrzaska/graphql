package com.ztrzaska.graphql.exceptions;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError handleGraphQLException(GraphQLException ex) {
        throw new GraphQLException(ex);
    }

    @ExceptionHandler(RuntimeException.class)
    public ThrowableGraphQLError handleGraphQLException(RuntimeException ex) {
        throw new RuntimeException("Internal Server Error", ex);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ThrowableGraphQLError handleGraphQLException(ConstraintViolationException ex) {
        throw new RuntimeException("Validation Error", ex);
    }
}
