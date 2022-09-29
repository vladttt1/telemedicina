package com.primforest.telemed;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DoctorService {

        List<Doctor> findAll();

    Doctor findByEmail(String email);

        List<Doctor> findAllBySpetiality(String speciality);

        Doctor saveOrUpdateDoctor(Doctor doctor);

        void deleteDoctorById(String id);

    }
