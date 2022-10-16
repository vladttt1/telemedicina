package com.primforest.telemed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "doctor_DB")
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    private int id;
    @lombok.Getter
    private  String doctorName;
    private String speciality;
    private String position;
    private String university;
    private String gratuatedYear;
    private String experienceYear;
    private String hopspitalName;
    private String linkedin;
    private String website;
    private String address;
    private String email;
    private String mobNumber;
    private String age;
    private int priceOfConsultation;
    private String appointmentTimeDoc;
    private String typeOfAppointment;




}
