package Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestRequestNewAppointment {
    private String appointmentTime;
    private String typeOfAppointment;
    private long appointmentId;
    private String patientName;
    private  String doctorName;
    private String speciality;

}
