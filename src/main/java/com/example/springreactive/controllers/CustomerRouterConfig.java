package com.example.springreactive.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class CustomerRouterConfig {

    @Bean
    public RouterFunction<?> helloRouter() {
        return route(GET("/hello"), request -> ok().body(Mono.just("Hello, world!"), String.class));
    }
}
