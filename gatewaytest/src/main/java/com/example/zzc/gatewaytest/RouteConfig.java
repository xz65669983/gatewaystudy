package com.example.zzc.gatewaytest;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
          /*      .route("blog", r ->
                        r.path("/test/getname").and().predicate(s->{return true;}).filters(f->f.stripPrefix(3)).uri("http://localhost:8081"))*/
                .route("blog", r ->
                        r.path("/test/getname").and().predicate(s->{return true;}).filters(f->f.filter(new RequestTimeFilter()).filter(new LogerFilter())).uri("http://localhost:8081"))

                .build();
    }
}
