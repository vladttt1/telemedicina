package com.primforest.telemed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl  implements  DoctorService{
    @Autowired
    ClinicRepository clinicRepository;
        @Override
        public Doctor findByEmail(String email){
           return clinicRepository.findAllByEmail();
        }

    public Doctor saveOrUpdateDoctor(Doctor doctor){
        return clinicRepository.save(doctor);}
    @Override
    public void deleteDoctorById(int id) {

    }

    public void deleteDoctorById(String id){
            clinicRepository.deleteDoctorById();
        }

    }
