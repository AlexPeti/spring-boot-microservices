package com.example.apigatewayservice.routing;

import com.example.apigatewayservice.security.CustomAuthenticationFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutingConfig {

    private CustomAuthenticationFilter filter;

    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/identity-service/api/auth/register",
                                "/identity-service/api/auth/authenticate")
                        .uri("lb://identity-service"))
                .route(r -> r.path("/identity-service/api/auth/logout")
                        .filters(f -> f.filter((GatewayFilter) filter))
                        .uri("lb://identity-service"))
                .route(r -> r.path("/demo-controller/api/test/demo-controller/greet")
                        .filters(f -> f.filter((GatewayFilter) filter))
                        .uri("lb://demo-controller"))
                .build();
    }
}
