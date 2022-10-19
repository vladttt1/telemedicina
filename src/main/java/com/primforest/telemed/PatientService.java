package com.primforest.telemed;

import Appointment.AppointmentEntity;
import Appointment.RestRequestNewAppointment;
import Appointment.RestResponseNewAppointment;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Accessors(fluent=true,chain=true)
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    RestResponseNewAppointment createNewAppointment(RestRequestNewAppointment restRequestNewAppointment) {
        AppointmentEntity newAppointmentEntity = AppointmentEntity.builder()
            .appointmentId(restRequestNewAppointment.getAppointmentId())
            .build();
        return null;
        //незакончен метод
    }
}
    /*public void addAmount() {
        BankProgram program= new BankProgram();

        program.run();
    }
}

        //AppointmentEntity
       // save1 = patientRepository.save(newAppointmentEntity);
       // return  RestResponseNewAppointment.fromPatient(save1);
    //}

//}
*/
