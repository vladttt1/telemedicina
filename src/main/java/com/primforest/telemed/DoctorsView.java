package com.primforest.telemed;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import java.util.List;




        @PageTitle("Doctors | Vaadin CRM")
        @PermitAll
        public class DoctorsView extends VerticalLayout {
            Grid<Doctor> grid = new Grid<>(Doctor.class);
            TextField filterText = new TextField();
            PatientService patientService;

ClinicRepository clinicRepository;
            public DoctorsView(PatientService patientService) {
                addClassName("list-view");
                setSizeFull();
                configureGrid();
                Image img=new Image("/src/main/java/resources/static/doctor.png","Our Doctors");
                img.setWidth("200px");
                add(img);
                Icon icon = new Icon("vaadin", "doctor");
                add(icon);
                add(getToolbar(), grid);
            }
    @PostConstruct
    public void fillGrid() {
        List<Doctor> doctors = clinicRepository.findAll();}
            private void configureGrid() {
                grid.addClassNames("doctor-grid");
                grid.setSizeFull();
                grid.setColumns("DoctorName", "Speciality", "email");


                grid.getColumns().forEach(col -> col.setAutoWidth(true));
            }

            private HorizontalLayout getToolbar() {
                filterText.setPlaceholder("Filter by name...");
                filterText.setClearButtonVisible(true);
                filterText.setValueChangeMode(ValueChangeMode.LAZY);
                filterText.addValueChangeListener(e -> updateList());

                Button addContactButton = new Button("Add doctor");

                HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
                toolbar.addClassName("toolbar");
                return toolbar;
            }
            private void updateList() {
                grid.setItems((Doctor) patientService.findAllPatients(filterText.getValue()));
            }
        }

