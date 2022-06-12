package com.primforest.telemed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PatientRepositoryTest{
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ClinicService clinicService;
    @Test
    public  void  createPatients(){
    patientRepository.save(new Patient(1, "Roma ", "Lazo 6", "roma@gmail", "+40732675490", "73", "male", "artrit", "Diclofenac", "RO", "10.50", "chat", 850, 54));
        patientRepository.save(new Patient(2, "Alex ", "Albisoara 56", "alex@gmail", "+40756228929", "63", "male", "extrasistolia", "Aspirin", "RO", "11.30", "chat", 180, 88));
        patientRepository.save(new Patient(3, "Edik ", "Sadovaia 76", "edik@gmail", "+407300000", "53", "male", "prostatit", "KLIZMA", "RU", "12.45", "teleconferentia", 2000, 104));
        patientRepository.save(new Patient(4, "Robert", "Nord 634", "rob@gmail", "+4073034500", "73", "male", "prostatit", "Prostamol", "EN", "10.45", "teleconferentia", 20, 14));
        System.out.println("Patient was added to MongoDB");
    patientRepository.findAll().forEach(System.out::println);
        System.out.println("This is patient with prostatit desease");

}

}
