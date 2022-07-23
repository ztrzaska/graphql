package pl.ztrzaska.graphql;

import graphql.kickstart.spring.web.boot.GraphQLWebsocketAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.ServletContext;
import java.util.Locale;

@SpringBootApplication(exclude = {
        GraphQLWebsocketAutoConfiguration.class     //only for passing test Error creating bean serverEndpointExporter
})
@ImportResource(value= "classpath:/package/hsql_cfg.xml")
public class GraphqlExampleApplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH); //hibernate validator messages language
        SpringApplication.run(GraphqlExampleApplication.class, args);
    }

}
