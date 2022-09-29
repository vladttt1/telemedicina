package com.primforest.telemed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelemedApplication {
    @Autowired
    ClinicRepository clinicRepository;


    public static void main(String[] args) {
        SpringApplication.run(TelemedApplication.class, args);
    }

}
