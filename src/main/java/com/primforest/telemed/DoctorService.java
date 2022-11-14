package com.primforest.telemed;

public interface DoctorService {


    Doctor findByEmail(String email);

        Doctor saveOrUpdateDoctor(Doctor doctor);

        void deleteDoctorById(int id);

    }
