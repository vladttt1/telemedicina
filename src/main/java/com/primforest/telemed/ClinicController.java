package com.primforest.telemed;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/allDoctors")
    public List<Doctor>getAllDoctors(){
        return clinicRepository.findAll(); }
    @PostMapping(value = "/newAppointment")
 public  void  newAppointment(@RequestBody RestRequestNewAppointment restRequestNewAppointment  ){
        clinicService.createNewAppointment(restRequestNewAppointment);}
    //@PostMapping(value = "/save")
    //public ResponseEntity<?> saveOrUpdateAppointment(@RequestBody Patient patient) {
        //clinicService.saveOrUpdateAppointment(ObjectMapperUtils.map(patient, Patient.class));
        //return new ResponseEntity("Appointment added successfully", HttpStatus.OK);
        @PostMapping("/newDoctor")
        public Doctor addNewDoctor (@RequestBody Doctor doctor){
            return clinicRepository.save(doctor);
        }

        @PostMapping("/newPatient")
        public Patient addNewPatient (@RequestBody Patient patient)
        {
            return patientRepository.save(patient);
        }
        @GetMapping(value = "/allPatientsByDiagnosis/{diagnosis}")
        public List<Patient> allPatientByDiagnosis (@PathVariable String diagnosis){
            return clinicService.allPatientsByDiagnosis(diagnosis);
        }
        @GetMapping("/patientById/{id}")
        public Optional<Patient> findAllPatientById ( @PathVariable int id){
            return patientRepository.findById(id);
        }
        @GetMapping("patientByName/{patientName}")
        public List<Patient> findAllPatientsByPatientName (@PathVariable String patientName){
            return clinicService.getPatientByName(patientName);
        }

        @GetMapping("/allPatients")
        public List<Patient> getAllPatients () {
            return patientRepository.findAll();
        }}
















