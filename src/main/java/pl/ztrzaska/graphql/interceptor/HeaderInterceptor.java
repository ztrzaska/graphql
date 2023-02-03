package pl.ztrzaska.graphql.interceptor;

import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Component
public class HeaderInterceptor implements WebGraphQlInterceptor {

    private final static String VERSION_HEADER_NAME = "version";

    @Override
    public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {
        final String versionHeader = request.getHeaders().getFirst(VERSION_HEADER_NAME);
        final String versionHeaderValue = versionHeader == null ? "1.0" : versionHeader;

        request.configureExecutionInput((executionInput, builder) ->
                builder.graphQLContext(Collections.singletonMap(VERSION_HEADER_NAME, versionHeaderValue)).build());
        return chain.next(request);
    }
}
