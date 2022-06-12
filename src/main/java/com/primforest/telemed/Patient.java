package com.primforest.telemed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import  java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("patient")
public class Patient {
    @Id
    private int id;
    private String patientName;
    private String address;
    private String email;
    private String mobNumber;
    private String age;
    private String gender;
    private String diagnosis;
    private String prescriptions;
    private String language;

    private String appointmentTime;
    private String typeOfAppointment;
    private  int balance;
    private int appointmentId;




}
