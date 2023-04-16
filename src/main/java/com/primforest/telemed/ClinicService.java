package com.primforest.telemed;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class  ClinicService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ClinicRepository clinicRepository;

    @Autowired
    public MongoTemplate mongoTemplate;


    public ClinicService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Doctor>allDoctorsBySpeciality(String speciality) {
                Query query=new Query()
                .addCriteria(Criteria.where("speciality").is(speciality))
                    ;
                return mongoTemplate.find(query, Doctor.class);
            }

    /*List<Doctor>allDoctorsBySpeciality(String speciality){
        return  clinicRepository.findAllBySpeciality();
    }*/
    public List<Patient>allPatientsByDoctor(String patientName){
        Query query3 = new Query();
        query3.addCriteria(Criteria.where("name").is(patientName));
        return mongoTemplate.find(query3,Patient.class);
}


    public  List<Patient>getPatientByName(String patientName) {
        Query query4=new Query();
        query4.addCriteria(Criteria.where("patientName").is(patientName))

        .with(Sort.by(Sort.Order.desc("patientName")))
            ;
        return mongoTemplate.find(query4,Patient.class);
    }
    /*Query =new Query();
        query.addCriteria(Criteria.where(patientName).is(patientName));
        return mongoTemplate.find(query,Patient.class);
*/
     public List<Patient>allPatientsByDiagnosis(String diagnosis){
        Query query5= new Query();
        query5.addCriteria(Criteria.where("diagnosis").is(diagnosis));
     return mongoTemplate.find(query5,Patient.class);
}
    //public void createNewAppointment(RestRequestNewAppointment restRequestNewAppointment) {
       //clinicRepository.createNewAppointment(restRequestNewAppointment);
    }


