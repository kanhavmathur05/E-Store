package com.estorebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("com.estorebackend")
@EnableAutoConfiguration
public class EstorebackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstorebackendApplication.class, args);
    }


//    @Bean
//    public FlywayMigrationStrategy flywayMigrationStrategy() {
//        return args -> {
//        };
//    }
}
