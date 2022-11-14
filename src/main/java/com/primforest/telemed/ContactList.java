package com.primforest.telemed;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@Route("doctors")
public class ContactList extends AppLayout {

    VerticalLayout layout;
    Grid<Doctor> grid;
    RouterLink linkCreate;

    @Autowired
    ClinicRepository clinicRepository;

    public ContactList(){
        layout = new VerticalLayout();
        grid = new Grid<>();
        grid = new Grid<>(Doctor.class);
        linkCreate = new RouterLink("CREATE DOCTOR",ManageContact.class,(int)(Math.random()*100+158));
        layout.add(linkCreate);
        layout.add(grid);
        addToNavbar(new H3("LIST OF DOCTORS"));
        setContent(layout);
    }
    @PostConstruct
    public void fillGrid(){
        List<Doctor> contacts = clinicRepository.findAll();
       if (!contacts.isEmpty()){
            //Выведем столбцы в нужном порядке
            grid.addColumn(Doctor::getDoctorName).setHeader("Name");
            grid.addColumn(Doctor::getSpeciality).setHeader("Speciality");
            grid.addColumn(Doctor::getPosition).setHeader("Position");
            grid.addColumn(Doctor::getMobNumber).setHeader("Номер");
            grid.addColumn(Doctor::getEmail).setHeader("E-mail");
            //Добавим кнопку удаления и редактирования*/
            grid.addColumn(new NativeButtonRenderer<Doctor>("Редактировать", contact -> {
                UI.getCurrent().navigate(ManageContact.class,contact.getId());
            }));
            grid.addColumn(new NativeButtonRenderer<Doctor>("Удалить", contact -> {
                Dialog dialog = new Dialog();
                Button confirm = new Button("Удалить");
                Button cancel = new Button("Отмена");
                dialog.add("Вы уверены что хотите удалить контакт?");
                dialog.add(confirm);
                dialog.add(cancel);
                confirm.addClickListener(clickEvent -> {
                    clinicRepository.delete(contact);
                    dialog.close();
                    Notification notification = new Notification("Контакт удален",1000);
                    notification.setPosition(Notification.Position.MIDDLE);
                    notification.open();
                    grid.setItems(clinicRepository.findAll());
                });
                cancel.addClickListener(clickEvent -> {
                    dialog.close();
                });
                dialog.open();
            }));
            grid.setItems(contacts);
        }
    }}

