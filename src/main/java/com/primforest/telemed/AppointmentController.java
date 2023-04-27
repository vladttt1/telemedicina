package com.primforest.telemed;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppointmentController {
    @Autowired
    ClinicRepository clinicRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ClinicService clinicService;
    @Autowired
    PatientService patientService;
    @Autowired
    AppointmentRepository appointmentRepository;
    @GetMapping("/allAppointments")
          public List<Appointment> getAllAppontments(){return appointmentRepository.findAll();}
        @PostMapping("/addAppointment")
                public Appointment addAppointment(Appointment appointment){
            return  appointmentRepository.save(appointment);

        }



}
