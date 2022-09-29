package com.primforest.telemed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.List;

@Service
public class DoctorServiceImpl  implements  DoctorService{
    @Autowired
    ClinicRepository clinicRepository;


        public List<Doctor> findAll(){
           return clinicRepository.findAll();
        }
        @Override
        public Doctor findByEmail(String email){
           return clinicRepository.findAllByEmail();
        }
         @Override
         public List<Doctor> findAllBySpetiality(String speciality) {
            return clinicRepository.findAllBySpeciality();
        };

        public Doctor saveOrUpdateDoctor(Doctor doctor){
        return clinicRepository.save(doctor);}

        public void deleteDoctorById(String id){
            clinicRepository.deleteDoctorById();
        }


    }
