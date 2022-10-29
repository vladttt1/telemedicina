package com.primforest.telemed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "doctor_DB")
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor

public class Doctor {
    @Id


    private int id;
    private  String doctorName;
    private String speciality;
    private String position;
    private String university;
    private String experienceYear;
    private String hopspitalName;
    private String website;
    private String email;
    private String mobNumber;
    private int priceOfConsultation;
    private String appointmentTimeDoc;
    private String typeOfAppointment;



    }

