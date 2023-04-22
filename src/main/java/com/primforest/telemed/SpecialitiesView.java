package com.primforest.telemed;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import javax.annotation.security.PermitAll;

@Route(value="Specialities",layout = MainLayout.class)
@PageTitle(" Specialities| Telemed")
@PermitAll
 public class SpecialitiesView extends VerticalLayout {

    public SpecialitiesView() {
        VerticalLayout todosList = new VerticalLayout();
        TextField taskField = new TextField();
        MenuBar menuBar = new MenuBar();
        MenuItem item = menuBar.addItem("Share");
        SubMenu subMenu = item.getSubMenu();
        subMenu.addItem("Facebook");
        subMenu.addItem("Twitter");
        subMenu.addItem("Instagram");
        subMenu.add(new Hr());
        subMenu.addItem("By email");
        subMenu.addItem("Get link");
        subMenu.add(new Hr());
        subMenu.addItem("Set permissions");

        Button addButton = new Button("Add");
        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            todosList.add(checkbox);

        });
        addButton.addClickShortcut(Key.ENTER);

        Image image = new Image("frontend/images/doctor.jpg", "OUR DOCTORS");
        add(image);
        StreamResource imageResource = new StreamResource("doctor1.png",
                () -> getClass().getResourceAsStream("/images/doctor1.png"));

        Image image1 = new Image(imageResource, "My Streamed Image");
        add(image1);
        Icon icon=new Icon(VaadinIcon.PHONE);
                add (icon);
        TextField field = new TextField("Street Address");
        field.setPrefixComponent(new Icon("vaadin", "map-marker"));
        field.setSuffixComponent(new Icon("vaadin", "building"));

// Wrap the icon inside a composition
        HorizontalLayout helper = new HorizontalLayout();
        helper.add(new Icon("vaadin", "info-circle-o"));
        helper.add(new Label("Here be help"));
        field.setHelperComponent(helper);

        add(field);
        add(
            new com.vaadin.flow.component.Component[]{new H1(" OUR DOCTORS BY MEDICAL SPECIALIZATIONS"),

                todosList, new HorizontalLayout(
                taskField,
                addButton,
                menuBar


            )});


    }}
        //RouterLink listLink = new RouterLink("Therapy", Therapy.class);
       // listLink.setHighlightCondition(HighlightConditions.sameLocation());
        //todosList.add(listLink);


