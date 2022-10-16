package com.primforest.telemed;

import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Accessors(fluent=true,chain=true)
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    RestResponseNewAppointment  createNewAppointment(RestRequestNewAppointment restRequestNewAppointment){
      AppointmentEntity newAppointmentEntity=  AppointmentEntity.builder()
        .appointmentId(restRequestNewAppointment.getAppointmentId())
          .build();
        return null;
    }}

        //AppointmentEntity
       // save1 = patientRepository.save(newAppointmentEntity);
       // return  RestResponseNewAppointment.fromPatient(save1);
    //}

//}

