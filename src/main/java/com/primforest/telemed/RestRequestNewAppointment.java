package com.primforest.telemed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestRequestNewAppointment {
    private String appointmentTime;
    private String typeOfAppointment;
    private int id;
    private String patientName;

}
