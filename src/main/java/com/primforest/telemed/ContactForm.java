package com.primforest.telemed;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

public class ContactForm extends FormLayout {
    private Patient patient;
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
    public void setContact(Patient patient) {
        this.patient = patient;
        binder.readBean(patient);
    }
    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    Binder<Patient> binder = new Binder<>(Patient.class);
    //Binder<Contact> binder = new BeanValidationBinder<>(Contact.class) нужно так
    public ContactForm(){
        addClassName("contact-form");
        binder.bindInstanceFields(this);
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

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, patient)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));
        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(patient);
            fireEvent(new SaveEvent(this, patient));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
    // Events
    public static abstract class ContactFormEvent extends ComponentEvent<ContactForm> {
        private final Patient patient;

        protected ContactFormEvent(ContactForm source, Patient patient) {
            super(source, false);
            this.patient = patient;
        }

        public Patient getContact() {
            return patient;
        }
    }

    public static class SaveEvent extends ContactFormEvent {
        SaveEvent(ContactForm source, Patient patient) {
            super(source, patient);
        }
    }

    public static class DeleteEvent extends ContactFormEvent {
        DeleteEvent(ContactForm source, Patient patient) {
            super(source, patient);
        }

    }

    public static class CloseEvent extends ContactFormEvent {
        CloseEvent(ContactForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }


}

