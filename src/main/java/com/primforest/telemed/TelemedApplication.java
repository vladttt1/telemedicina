package com.primforest.telemed;

import PatientAccount.BankProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class TelemedApplication {
    @Autowired
    ClinicRepository clinicRepository;
    @Autowired
    MessageRepository messageRepository;


    public static void main(String[] args) {
        SpringApplication.run(TelemedApplication.class, args);

    BankProgram program=new BankProgram();
        program.run();
}}
