package com.primforest.telemed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicRepository extends MongoRepository <Doctor,Integer> {

    void deleteDoctorById();

    List<String> findAllBydoctorName();

    List<Doctor> findDoctorsByDoctorName(String stringFilter);


    //createNewAppointment(RestRequestNewAppointment restRequestNewAppointment);
}

