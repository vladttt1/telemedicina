package com.primforest.telemed;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@Route(value="", layout = MainLayout.class)


    @PageTitle("Patients | Telemedicine")

    public class ListViewPatient extends VerticalLayout {
        Grid<Patient> grid = new Grid<>(Patient.class);
        TextField filterText = new TextField();
        ContactForm contactForm;
        PatientService patientService;

        public ListViewPatient(PatientService patientService) {
            this.patientService = patientService;
            addClassName("list-view-patient");
            setSizeFull();
            configureGrid();
            configureForm();
            //Image img=new Image("/src/main/resources/static/doctor1.png","Patients");
            //img.setWidth("800px");
            //add(img);
            //Icon icon = new Icon("vaadin", "doctor");
            //add(icon);
            add(getToolbar(), getContent());updateList();
            closeEditor();
        }
private Component getContent(){
    HorizontalLayout content = new HorizontalLayout(grid,contactForm);
    content.setFlexGrow(2, grid);
    content.setFlexGrow(1,contactForm);
    content.addClassNames("content");
    content.setSizeFull();
    return content;
        }
         void configureForm() {
            contactForm= new ContactForm();
            contactForm.setWidth("25em");
            contactForm.addListener(ContactForm.SaveEvent.class, this::savePatient);
            contactForm.addListener(ContactForm.DeleteEvent.class, this::deletePatient);
            contactForm.addListener(ContactForm.CloseEvent.class, e -> closeEditor());
        }
     void savePatient(ContactForm.SaveEvent event) {
        patientService.savePatient(event.getContact());
        updateList();
        closeEditor();
    }

     void deletePatient(ContactForm.DeleteEvent event) {
        patientService.deletePatient(event.getContact());
        updateList();
        closeEditor();
    }

//здесь нужно добавить 2 List для combobox - если нужно
        private void configureGrid() {
            grid.addClassNames("patient-grid");
            grid.setSizeFull();
            grid.setColumns("id","patientName",  "email","mobNumber","age","gender","diagnosis","prescriptions","language",
               "balance","doctorNameForPatient","appointmentTime","typeOfAppointment","description" );

            grid.getColumns().forEach(col -> col.setAutoWidth(true));
            grid.asSingleSelect().addValueChangeListener(event ->
                editPatient(event.getValue()));
        }

        private HorizontalLayout getToolbar() {
            filterText.setPlaceholder("Filter by name...");
            filterText.setClearButtonVisible(true);
            filterText.setValueChangeMode(ValueChangeMode.LAZY);
            filterText.addValueChangeListener(e -> updateList());

            Button addPatientButton = new Button("Add Patient");
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
            editPatient(new Patient());
        }
    private void updateList() {
        grid.setItems(patientService.findAllPatients(filterText.getValue()));
    }
    }

