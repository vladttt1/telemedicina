package com.primforest.telemed;


import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

public class ContactForm extends FormLayout {
    TextField patientName = new TextField("Patient");
    TextField mobileNumber = new TextField("MobileNumb");
    TextField age=new TextField("age");
    TextField gender=new TextField("Gender");
    TextField diagnosis=new TextField("diagnosis");
    TextField prescriptions=new TextField("Prescriptions");

    EmailField email = new EmailField("Email");
    TextField balance= new TextField("balance");
    TextField description= new TextField("Description");
    TextField appointmentTime=new TextField("apointmentTime");
    TextField typeOffAppointment=new TextField("typeOffAppointment");
TextField language=new TextField("Language");
    TextField doctorNameForPatient=new TextField("doctorNameForPatient)");


    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    public ContactForm(){
        addClassName("contact-form");

        add(patientName,
            email,
            mobileNumber,
            age,
            gender,
            diagnosis,
            prescriptions,
            language,
            balance,
            description,
            appointmentTime,
            typeOffAppointment,
            doctorNameForPatient,

            createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close);
    }
}

