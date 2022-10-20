package com.primforest.telemed;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
@Route("manageContact")
public class ManageContact extends AppLayout implements HasUrlParameter<Integer> {

    Integer id;
    FormLayout contactForm;
    TextField doctorName;
    TextField speciality;
    TextField position;
    TextField mobNumber;
    TextField email;
    TextField university;
    TextField experienceYear;
    TextField hospitalName;
    TextField priceOfConsultation;
    TextField appointmentTimeDoc;
    TextField typeOfAppointment;
    TextField website;
    Button saveContact;

    @Autowired
    ClinicRepository clinicRepository;

    public ManageContact(){

        contactForm = new FormLayout();
        doctorName = new TextField("Name");
        speciality = new TextField("Speciality");
        position = new TextField("Position");
        mobNumber = new TextField("mobNumber");
        email = new TextField("email");
         university=new TextField("University");
         experienceYear=new TextField("ExperienceYears");
          hospitalName =new TextField("hopspitalName");
         priceOfConsultation=new TextField("priceOfConsultation");
         appointmentTimeDoc=new TextField("appointmentTimeDoc");
         typeOfAppointment=new TextField(" typeOfAppointment");
         website=new TextField("website");
        saveContact = new Button("Сохранить");
        website=new TextField("WebSITE");

        //Добавим все элементы на форму
        contactForm.add(doctorName, speciality,position,mobNumber,email,university,experienceYear,hospitalName,priceOfConsultation,appointmentTimeDoc,typeOfAppointment,website,saveContact);
        setContent(contactForm);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer contactId) {
        id = contactId;
        if (!id.equals(0)){
            addToNavbar(new H3("Редактирование контакта"));
        }
        else {
            addToNavbar(new H3("Создание контакта"));
        }
        fillForm();
    }

    public void fillForm(){
        if (!id.equals(0)){
            Optional<Doctor> doctor = clinicRepository.findById(id);
            doctor.ifPresent(x -> {
                doctorName.setValue(x.getDoctorName());
                speciality.setValue(x.getSpeciality());
                position.setValue(x.getPosition());
                mobNumber.setValue(x.getMobNumber());
                email.setValue(x.getEmail());
                university.setValue(x.getUniversity());
                experienceYear.setValue(x.getExperienceYear());
                hospitalName.setValue(x.getHopspitalName());
                priceOfConsultation.setValue(String.valueOf(x.getPriceOfConsultation()));
                appointmentTimeDoc.setValue(x.getAppointmentTimeDoc());
                typeOfAppointment.setValue(x.getTypeOfAppointment());
                website.setValue(x.getWebsite());
            });
        }
        saveContact.addClickListener(clickEvent->{
            //Создадим объект контакта получив значения с формы
            Doctor doctor = new Doctor();
            if (!id.equals(0)){
                doctor.setId(id);
            }
            doctor.setDoctorName(doctorName.getValue());
            doctor.setSpeciality(speciality.getValue());
            doctor.setPosition(position.getValue());
            doctor.setEmail(email.getValue());
            doctor.setMobNumber(mobNumber.getValue());
             doctor.setUniversity(university.getValue());
             doctor.setExperienceYear(experienceYear.getValue());
             doctor.setHopspitalName(hospitalName.getValue());
             doctor.setPriceOfConsultation(Integer.parseInt(priceOfConsultation.getValue()));
             doctor.setAppointmentTimeDoc(appointmentTimeDoc.getValue());
             doctor.setTypeOfAppointment(typeOfAppointment.getValue());
             doctor.setWebsite(website.getValue());
            clinicRepository.save(doctor);

            Notification notification = new Notification(id.equals(0)? "Контакт успешно создан":"Контакт был изменен",1000);
            notification.setPosition(Notification.Position.MIDDLE);
            notification.addDetachListener(detachEvent -> {
                UI.getCurrent().navigate(ContactList.class);
            });
            contactForm.setEnabled(false);
            notification.open();
        });
    }
}


