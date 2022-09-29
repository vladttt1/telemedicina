package com.primforest.telemed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestResponseNewAppointment {

    private String appointmentTime;
    private String typeOfAppointment;
    private int id;
    private String patientName;
    public static RestResponseNewAppointment fromPatient(Patient patient){
        return RestResponseNewAppointment.builder()
            .patientName(patient.getPatientName())
            .id(patient.getId())
            .appointmentTime(patient.getAppointmentTime())
            .build();
    }

}
