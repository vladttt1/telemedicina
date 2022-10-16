package com.primforest.telemed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends MongoRepository <Doctor,Integer> {
    Doctor findAllByEmail();
    void deleteDoctorById();

    void createNewAppointment(RestRequestNewAppointment restRequestNewAppointment);
}

