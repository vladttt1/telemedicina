package com.primforest.telemed;
/*
import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.StatusRepository;
import org.springframework.stereotype.Service;
*/

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository
                      ) {
        this.patientRepository=patientRepository;
    }

    public List<Patient> findAllPatients(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return patientRepository.findAll();
        } else {
            return patientRepository.findAllPatientsByPatientName(stringFilter);
        }
    }

    public long countPatients() {
        return patientRepository.count();
    }

    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }

    public void savePatient(Patient patient) {
        if (patient == null) {
            System.err.println("Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        patientRepository.save(patient);
    }


}
