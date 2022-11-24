package com.primforest.telemed;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient,Integer> {


    void deleteDoctorById();


    List<Patient> findAllByPatientName(String stringFilter);

    List<Patient> findAllPatientsByPatientName(String stringFilter);
}
