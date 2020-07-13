package com.example.zzc.gatewaytest;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class LogerFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("老子进入方法了！！"+exchange.getRequest().getPath());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    System.out.println("老子退出方法了！！"+exchange.getRequest().getPath());
                })
        );
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
