package com.primforest.telemed;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Appointments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    private int appointmentId;
    private String patientName;
    private String appointmentTime;
    private String typeOfAppointment;
    private String docSpeciality;
    private String doctorName;


Appointment appointment= Appointment.builder()
        .appointmentId(getAppointmentId())
        .patientName(getPatientName())
    .appointmentTime(getAppointmentTime())
        .typeOfAppointment(getTypeOfAppointment())
        .doctorName(getDoctorName())
        .docSpeciality(getDocSpeciality()).build();


}
