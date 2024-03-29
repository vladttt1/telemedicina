package com.primforest.telemed;

import PatientAccount.BankProgram;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
@Autowired
PatientService patientService;

    @Autowired
    public ClinicController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/allDoctors")
    public List<Doctor>getAllDoctors(){
        return clinicRepository.findAll(); }
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
        @GetMapping ("/jitsiCall")
        ///does not work
        public ModelAndView callJitsi(){
        return new ModelAndView("JitsiPath"
                );
        }
    @GetMapping("/docSpeciality/{speciality}")
    List<Doctor>getSpetialities(@PathVariable String speciality){
        return clinicService.allDoctorsBySpeciality(speciality);
    }
@GetMapping
    (value = "/findDoctors/{doctorName}")
public  List<String>getDoctorByName(@PathVariable String doctorName){
        return clinicRepository.findAllBydoctorName();
}
        @GetMapping("/allPatients")
        public List<Patient> getAllPatients () {
            return patientRepository.findAll();
        }
         @GetMapping("/addAmount/{amount}")
         // need to Rewrite BankProgram
public  void addAmount(@PathVariable int amount){
            // patientService.addAmount();
             BankProgram program= new BankProgram();
             program.run();
         }
    public DoctorService getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}















