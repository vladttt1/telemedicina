package com.primforest.telemed;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ClinicController {
    MongoTemplate mongoTemplate;
    @Autowired
     ClinicRepository clinicRepository;
@Autowired
PatientRepository patientRepository;
   @Autowired
    private DoctorService doctorService;
@Autowired
  private ClinicService clinicService;
    /*@PostMapping(value = "/saveAppointment")

 public  void  newAppointment(@RequestBody RestRequestNewAppointment restRequestNewAppointment  ){
        clinicService.createNewAppointment(restRequestNewAppointment);}

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateAppointment(@RequestBody Patient patient) {
        clinicService.saveOrUpdateAppointment(ObjectMapperUtils.map(patient, Patient.class));
        return new ResponseEntity("Appointment added successfully", HttpStatus.OK);
*/       @PostMapping("/newDoctor")
       public Doctor addNewDoctor(@RequestBody Doctor doctor){
    return clinicRepository.save(doctor);
    }

        @PostMapping("/newPatient")
        public Patient addNewPatient(@RequestBody Patient patient)
        {
           return patientRepository.save(patient);
        }

      @ GetMapping("/contact")
      public String saveContactDetails(String input){
        return " All details will be save in DB";
      }
      /*@GetMapping("/balance/{id}")
      public  double saveBalance(double balance)(@PathVariable
    Patient id){
          return patientRepository.findById(saveBalance(double myBalance));
      }

*/
@GetMapping("/allPatients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
     @GetMapping("/getPatientByName/{patientName}")
     public List<Patient> getPatientByName(@PathVariable String patientName){
      /*Query =new Query();
        query.addCriteria(Criteria.where(patientName).is(patientName));
        return mongoTemplate.find(query,Patient.class);
*/
       return  patientRepository.findAllByPatientName(patientName);

    /*
    @GetMapping(value = "/findDoctorByEmail/{email}"){
        public List<Doctor>findDoctorByEmail(@PathVariable String email){
            return doctorService.findByEmail(email);
        }


    @GetMapping("/allDoctorsBySpeciality/{speciality}")
    public List<Doctor>allDoctorsBySpeciality(@PathVariable String speciality) {
        return clinicService.allDoctorsBySpeciality(speciality);
    }


    @GetMapping(value = "/allPatientsByDiagnosis/{diagnosis}")
    public List<Patient> allPatientByDiagnosis(@PathVariable String diagnosis) {
        return clinicService.allPatientsByDiagnosis(diagnosis);
    }
         @GetMapping("/getAllDoctors")
         public List<Doctor> getAllDoctors() {
             return
                 clinicRepository.findAll();
         }
         */

    }}


