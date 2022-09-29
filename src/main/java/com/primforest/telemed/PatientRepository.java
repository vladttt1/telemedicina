package com.primforest.telemed;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PatientRepository extends MongoRepository<Patient,Integer> {
    @Query("{'name':?0}")
    List<Patient>findAllByPatientName(String patientName);
    void deleteDoctorById();


}
