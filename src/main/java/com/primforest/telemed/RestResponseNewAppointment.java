package com.primforest.telemed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent=true,chain=true)
@Data

public class RestResponseNewAppointment {
@Autowired
PatientRepository patientRepository;
    private String appointmentTime;
    private String typeOfAppointment;
    private long id;
    private String patientName;
    public static RestResponseNewAppointment fromPatient(AppointmentEntity patient){
        return RestResponseNewAppointment.builder()
            .patientName(patient.getPatientName())
            .id(patient.getAppointmentId())
            .appointmentTime(patient.getAppointmentTime())
            .typeOfAppointment(patient.getTypeOfAppointment())

            .build();

    }


}
