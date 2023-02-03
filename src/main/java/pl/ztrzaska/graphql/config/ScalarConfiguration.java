package pl.ztrzaska.graphql.config;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.util.List;

@Configuration
public class ScalarConfiguration {

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> {
            List.of(wiringBuilder.scalar(ExtendedScalars.Date), wiringBuilder.scalar(ExtendedScalars.DateTime));
        };
    }
}
