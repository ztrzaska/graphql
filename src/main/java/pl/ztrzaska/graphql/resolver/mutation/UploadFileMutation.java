package pl.ztrzaska.graphql.resolver.mutation;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class UploadFileMutation implements GraphQLMutationResolver {

    public UUID uploadFile(DataFetchingEnvironment environment) {
        log.info("Uploading a file");

        DefaultGraphQLServletContext context = environment.getContext();

        context.getFileParts().forEach(
                t -> log.info("Uploading: {}, size: {}", t.getSubmittedFileName(), t.getSize()));

        return UUID.randomUUID();
    }
}
