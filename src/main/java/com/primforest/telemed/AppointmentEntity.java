package com.primforest.telemed;

import com.primforest.telemed.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Appointments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentEntity {
    @Autowired
    PatientRepository patientRepository;
    private String appointmentTime;
    private String typeOfAppointment;
    private long appointmentId;
    private String patientName;
    private String docSpeciality;
    private String  doctorName;

}
