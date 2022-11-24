package com.primforest.telemed;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.time.LocalDate;
import java.time.ZoneId;

@Route("")
@PermitAll
public class MainView extends VerticalLayout {

    public MainView() {
        VerticalLayout todosList = new VerticalLayout();
        TextField taskField = new TextField();
        Button addButton = new Button("Add doctor");
        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            todosList.add(checkbox);
        });
        addButton.addClickShortcut(Key.ENTER);
        DatePicker datePicker = new DatePicker("Start date");
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        Icon icon = new Icon("vaadin", "doctor");
        add(icon);
        datePicker.setMin(now);
        datePicker.setMax(now.plusDays(60));
        datePicker.setHelperText("Must be within 60 days from today");
        add(datePicker);
        add(
        new H1("WELCOME TO TELEMEDECINE"),
            todosList,
            new HorizontalLayout(
                taskField,
                addButton
            )
    );
    }
}
