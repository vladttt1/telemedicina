package com.primforest.telemed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment-order")
public class ClinicController {
    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    ClinicService clinicService;

    @PostMapping("/saveAppointment")
    public String saveAppointment(@RequestBody Doctor doctor, Patient patient) {
        clinicRepository.save(doctor);
        patientRepository.save(patient);
        return "Appointment to doctor saved successfully";
    }



    @PostMapping("/savePatient")
    public String savePatient(@RequestBody Patient patient, Doctor doctor) {
        patientRepository.save(patient);
        clinicRepository.save(doctor);
        return "Patient saved successfully";
    }

    @GetMapping("/getAllPatients")
    public List<Patient>getAllPatients() {
        return patientRepository.findAll();
    }
     @GetMapping("/getPatientByName/{patientName}")
     public List<Patient>getPatientByName( @PathVariable (required =false)String patientName){
         return clinicService.getPatientByName(patientName);

    }
    @GetMapping("/getAllDoctors")
    public List<Doctor> getAllDoctors() {
        return
            clinicRepository.findAll();
    }

    @GetMapping("/allDoctorsBySpeciality/{speciality}")
    public List<Doctor> allDoctorsBySpeciality(@PathVariable String speciality) {
        return clinicService.allDoctorsBySpeciality(speciality);
    }


    @GetMapping("/allPatientByDiagnosis/{diagnosis}")
    public List<Patient> allPatientByDiagnosis(@PathVariable String diagnosis) {
        return clinicService.allPatientByDiagnosis();
    }
}
