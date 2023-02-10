package com.example.eurikadiscovering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurikaDiscoveringApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurikaDiscoveringApplication.class, args);
    }

}
