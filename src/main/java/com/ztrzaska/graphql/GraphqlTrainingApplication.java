package com.ztrzaska.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.util.Locale;

@SpringBootApplication
public class GraphqlTrainingApplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH); //hibernate validator messages language
        SpringApplication.run(GraphqlTrainingApplication.class, args);
    }

}
