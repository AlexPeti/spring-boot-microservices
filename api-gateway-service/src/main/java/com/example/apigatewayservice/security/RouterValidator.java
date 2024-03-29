package com.example.apigatewayservice.security;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    public static final List<String> openEndpoints = List.of(
            "/identity-service/api/v1/auth/register",
            "/identity-service/api/v1/auth/authenticate"
    );

    public Predicate<ServerHttpRequest> isSecured = request -> openEndpoints.stream()
            .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
