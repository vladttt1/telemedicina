package com.primforest.telemed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicRepository extends MongoRepository <Doctor,Integer> {

    void deleteDoctorById();

    List<String> findAllBydoctorName();

    List<Doctor> findDoctorsByDoctorName(String stringFilter);

    List<Doctor> findAllBySpeciality();

    //List<Doctor> allDoctorsBySpeciality();




    /*@Query("select c from Doctor c " +
            "where lower(c.speciality) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.doctorName) like lower(concat('%', :searchTerm, '%'))")
        List<Doctor> search(@Param("searchTerm") String searchTerm);

*/
    //createNewAppointment(RestRequestNewAppointment restRequestNewAppointment);
}

