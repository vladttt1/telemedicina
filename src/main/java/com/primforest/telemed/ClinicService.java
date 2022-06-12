package com.primforest.telemed;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.List;

import  org.springframework.data.mongodb.core.query.Criteria;

@Service
public class ClinicService {
    MongoTemplate mongoTemplate;

    public  ClinicService(MongoTemplate mongoTemplate){this.mongoTemplate=mongoTemplate;}
    public List<Doctor>allDoctorsBySpeciality(String speciality) {
                Query query=new Query()
                .addCriteria(Criteria.where("speciality").is(speciality))
                    .with(Sort.by(Sort.Order.desc("speciality")))
                    .limit(10);
                return (List<Doctor>) mongoTemplate.find(query, Doctor.class);
            }
public List<Patient>allPatientByDiagnosis(){
    Query query2 = new Query();
    query2.addCriteria(Criteria.where("diagnosis").is("prostatit"));
    return (List<Patient>)mongoTemplate.find(query2,Patient.class);

}
    public List<Patient>allPatientByDoctor(String patientName){
        Query query3 = new Query();
        query3.addCriteria(Criteria.where("name").is(patientName));
        return (List<Patient>)mongoTemplate.find(query3,Patient.class);
}


    public  List<Patient>getPatientByName(String patientName) {
        Query query4=new Query();
        query4.addCriteria(Criteria.where("patientName").is(patientName))

        .with(Sort.by(Sort.Order.desc("patientName")))
            .limit(10);
        return (List<Patient>)mongoTemplate.find(query4,Patient.class);
    }
     public List<Patient>allPatientByDiagnosis(String diagnosis){
        Query query5= new Query();
        query5.addCriteria((Criteria.where("diagnosis").is(diagnosis)));
     return  (List<Patient>)mongoTemplate.find(query5,Patient.class);

}}

