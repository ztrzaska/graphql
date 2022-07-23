package pl.ztrzaska.graphql.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalarConfiguration {

    @Bean
    public GraphQLScalarType graphQLDate() {
        return ExtendedScalars.Date;
    }

    @Bean
    public GraphQLScalarType graphQLDateTime() {
        return ExtendedScalars.DateTime;
    }
}
