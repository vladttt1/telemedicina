package com.primforest.telemed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class ClinicRepositoryTest {
    @Autowired
    ClinicRepository clinicRepository;

    @Autowired
    ClinicService clinicService;

    @Test
    public void createRows() {
        clinicRepository.save(new Doctor(98, "George", "Urologist", "sef doctor", "Bacau Med Univer", "33", "Sf Prascovia ", "www.urol.com", "george@gmail.com", "+37373448899", 417, "11", "chat "));

        clinicRepository.save(new Doctor(8, "Vasil", "Cardiologist", "major doctor", "Chisinau Med Univer", "30", "Clinic Republican", "www.cardiologic.com,", "ion@gmail.com", "+377774500", 380, "15", "online "));
        clinicRepository.save(new Doctor(9, "Stefan", "Oftalmologist", "sef doctor", "Chisinau Med Univer", "15", "1 hospital", "www.oftalm.com,", "stefan@gmail.com", "+3736000054", 300, "10", "chat "));
        clinicRepository.findAll().forEach(System.out::println);
        System.out.println("THERE ARE OUR DOCTORS");


    }

    }




