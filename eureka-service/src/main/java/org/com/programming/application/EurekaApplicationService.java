package org.com.programming.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplicationService {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationService.class, args);
    }
}