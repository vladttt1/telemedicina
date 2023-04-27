package com.primforest.telemed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class TelemedApplication {




    public static void main(String[] args) {
        SpringApplication.run(TelemedApplication.class, args);

}}
