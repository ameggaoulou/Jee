package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    //@Bean
    //public RouteLocator routes(RouteLocatorBuilder builder) {
    //return builder.routes()
    //    .route(r->r.path("/students/**").uri("lb://student-service"))
    //  .route(r->r.path("/courses/**").uri("lb://course-service"))
    // .route(r->r.path("/professors/**").uri("lb://professors-service"))
    //  .build();
    //  }
    @Bean
    public DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
                                                               DiscoveryLocatorProperties probarties){
        return new DiscoveryClientRouteDefinitionLocator(rdc,probarties);
    }
}
