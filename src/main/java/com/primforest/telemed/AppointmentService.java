package com.primforest.telemed;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
public class AppointmentService {

    private final ClinicRepository clinicRepository;
    private final PatientRepository patientRepository;


    public  AppointmentService(ClinicRepository clinicRepository, PatientRepository patientRepository
    ) {
        this.clinicRepository = clinicRepository;
        this.patientRepository=patientRepository;
    }



    public List<Doctor> findAllDoctors(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return clinicRepository.findAll();}
    else  return clinicRepository.findAllBySpeciality();}

    public void savePatient(Patient patient) {
        if (patient == null) {
    patient.setId((int)(Math.random()*100+12));//иначе невозможно присвоить id-в MongoDB
        patientRepository.save(patient);
        }}

    public MongoTemplate mongoTemplate;


    public void appointmentService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Doctor>allDoctorsBySpeciality(String speciality) {
        Query query=new Query()
            .addCriteria(Criteria.where("speciality").is(speciality))
            .with(Sort.by(Sort.Order.desc("speciality")))
            .limit(20);
        return mongoTemplate.find(query, Doctor.class);
    }}
//это метод из patientService переработан
         /*else {
            return clinicRepository.search(stringFilter);
       }
    }}

    public long countContacts() {
        return clinicRepository.count();
    }

    public void deleteContact(Doctor doctor) {
        clinicRepository.delete(doctor);
    }

    public void saveContact(Doctor doctor) {
        if (doctor == null) {
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        clinicRepository.save(doctor);
    }



}*/

