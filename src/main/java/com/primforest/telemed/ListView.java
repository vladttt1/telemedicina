package com.primforest.telemed;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.PostConstruct;
import java.util.List;

@Route("contacts")


        @PageTitle("Doctors | Vaadin CRM")
        public class ListView extends VerticalLayout {
            Grid<Doctor> grid = new Grid<>(Doctor.class);
            TextField filterText = new TextField();

ClinicRepository clinicRepository;
            public ListView() {
                addClassName("list-view");
                setSizeFull();
                configureGrid();

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

                Button addContactButton = new Button("Add doctor");

                HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
                toolbar.addClassName("toolbar");
                return toolbar;
            }
        }

