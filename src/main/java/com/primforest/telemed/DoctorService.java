package com.primforest.telemed;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {
    private final ClinicRepository clinicRepository;

    public DoctorService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public List<Doctor> findAllDoctors(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return clinicRepository.findAll();
        } else {
            return clinicRepository.findDoctorsByDoctorName(stringFilter);
        }
    }

    public long countDoctors() {
        return clinicRepository.count();
    }

    public void deleteDoctor(Doctor doctor) {
        clinicRepository.delete(doctor);
    }

    public void saveDoctor(Doctor doctor) {
        if (doctor == null) {
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        clinicRepository.save(doctor);
    }


    public void saveOrUpdateDoctor(Doctor doctor) {clinicRepository.save(doctor);
    }

    public void find(String value) {
        clinicRepository.findAll();

    }

    public List<Doctor> findAll() { return clinicRepository.findAll();
    }
}


