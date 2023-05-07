package com.primforest.telemed;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
@Push
public class TelemedApplication  implements AppShellConfigurator {




    public static void main(String[] args) {
        SpringApplication.run(TelemedApplication.class, args);

}}
