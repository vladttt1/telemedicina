package com.primforest.telemed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClinicRepositoryTest {
    @Autowired
    ClinicRepository clinicRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ClinicService clinicService;
    @Test
    public void  createRows(){
        clinicRepository.save(new Doctor(3,"George","Urologist","sef doctor","Bacau Med Univer","1984","33","Sf Prascovia ","www.ur1.com,","www.urol.com"," Iegova str 11 ","george@gmail.com","+37373448899","60",417,"11", "chat "));
        clinicRepository.save(new Doctor(7,"Ion","Urologist","major doctor","Bucuresti Med Univer","1980","23","Sf Treimea ","www.ur.com,","www.urol.com","Puskin str 50 ","ion@gmail.com","+3736845954","40",410,"14", "online "));
        clinicRepository.save(new Doctor(8,"Vasil","Cardiologist","major doctor","Chisinau Med Univer","1999","30","Clinic Republican","www.cardiologic.com,","www.urol.com","B Voievod str 5 ","ion@gmail.com","+377774500","43",380,"15", "online "));
        clinicRepository.save(new Doctor(9,"Stefan","Oftalmologist","sef doctor","Chisinau Med Univer","1984","15","1 hospital","www.oftalm.com,","www.urol.com","St cel Mare str 5 ","stefan@gmail.com","+3736000054","50",300,"10", "chat "));
    clinicRepository.findAll().forEach(System.out::println);
    System.out.println("THERE ARE OUR DOCTORS");



    }

}


