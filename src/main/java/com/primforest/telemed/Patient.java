package com.primforest.telemed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="patient")
public class Patient {
    @Id

    private int id;
    private String patientName;
    @Email
    @NotEmpty
    private String email;
    private String mobNumber;
    private int age;
    private String gender;
    private String diagnosis;
    private String prescriptions;
    private String language;
    private double balance;
  private String description;
    private String appointmentTime;
    private String typeOfAppointment;
    private String doctorNameForPatient;

    @Override
    public  String toString(){return "New appoitment for" + patientName +
    "with" + id + "at " + appointmentTime;}




}
