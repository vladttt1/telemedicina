package com.primforest.telemed;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient,Integer> {
 List<Patient> findAllPatientsByPatientName();

    void deleteDoctorById();


    void balanceByName(String patientName);
}
