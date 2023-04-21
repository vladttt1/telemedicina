package com.primforest.telemed;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="Apointment",layout = MainLayout.class)

@PageTitle("Appointment| Telemed")

    public class Appointment extends VerticalLayout {

    Grid<Doctor> grid = new Grid<>(Doctor.class);
        TextField filterText = new TextField();
        ContactForm contactForm;
         AppointmentService appointmentService;
       PatientRepository patientRepository;
         ClinicService clinicService;
         PatientService patientService;

        public Appointment(AppointmentService appointmentService, PatientService patientService,
                           ClinicService clinicService) {
            this.appointmentService=appointmentService;
            this.patientService=patientService;
            this.clinicService=clinicService;
            addClassName("therapy");
            setSizeFull();
            configureGrid();
            configureForm();
            Icon icon = new Icon("vaadin", "doctor");
            add(icon);



            add(getToolbar(), getContent(), new H1(" make appointment here"));updateList();closeEditor();}

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, contactForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, contactForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;

    }
     void configureForm() {
        contactForm = new ContactForm();
        contactForm.setWidth("25em");
        contactForm.addListener(ContactForm.SaveEvent.class, this::savePatient);
        contactForm.addListener(ContactForm.DeleteEvent.class, this::deletePatient);
        contactForm.addListener(ContactForm.CloseEvent.class, e -> closeEditor());}
         void savePatient(ContactForm.SaveEvent event) {

            patientService.savePatient(event.getPatient());


//  или с новым методом в appointmentService
            updateList();
            closeEditor();

        }

    void deletePatient(ContactForm.DeleteEvent event) {
        patientService.deletePatient(event.getPatient());
        updateList();
        closeEditor();
    }
        private void configureGrid() {
            grid.addClassNames("therapy-grid");
            grid.setSizeFull();
            grid.setColumns("id","doctorName", "speciality", "position","email","university","experienceYear","hospitalName",
                "priceOfConsultation","typeOfAppointment","website");

            grid.getColumns().forEach(col -> col.setAutoWidth(true));
            //grid.asSingleSelect().addValueChangeListener(event ->
            //editPatient(event.getValue()));
            //    не редактируем Grid
        }

        private HorizontalLayout getToolbar() {
            filterText.setPlaceholder("Filter by name...");
            filterText.setClearButtonVisible(true);
            filterText.setValueChangeMode(ValueChangeMode.LAZY);
            filterText.addValueChangeListener(e -> updateList());
            Button addPatientButton = new Button("ADD APPOINTMENT");
            addPatientButton.addClickListener(click -> addPatient());
            HorizontalLayout toolbar = new HorizontalLayout(filterText, addPatientButton);
            toolbar.addClassName("toolbar");
            return toolbar;
        }
    public void editPatient(Patient patient) {
        if (patient == null) {
            closeEditor();
        } else {
            contactForm.setContact(patient);
            contactForm.setVisible(true);
            addClassName("editing");
        }}
    private void closeEditor() {
        contactForm.setContact(null);
        contactForm.setVisible(false);
        removeClassName("editing");
    }

    private void addPatient() {
        grid.asSingleSelect().clear();
        editPatient
            (new Patient());
    }

          private void updateList() {

             // grid.setItems(clinicService.allDoctorsBySpeciality(filterText.getValue()));
            grid.setItems(appointmentService.findAllDoctors(filterText.getValue()));
              //grid.setItems(clinicRepository.findAll());
          }
    //private void addDependencies() {
        //com.vaadin.flow.component.UI.getCurrent().getPage()
           // .addJavaScript("/meet.jit.si/external_api.js");/ пытался добавить Jitsi

    }





