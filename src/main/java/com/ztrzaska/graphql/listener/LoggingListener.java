package com.ztrzaska.graphql.listener;

import graphql.kickstart.servlet.core.GraphQLServletListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingListener implements GraphQLServletListener {

    private final Clock clock;

    @Override
    public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {
        Instant startTime = Instant.now(clock);
        log.info("Graphql request received");
        return new RequestCallback() {

            @Override
            public void onFinally(HttpServletRequest request, HttpServletResponse response) {
                log.info("Graphql request completed, takes: {}", Duration.between(startTime, Instant.now(clock)));
            }
        };
    }
}
